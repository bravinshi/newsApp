package com.bravin.shi.news.web.controller;

import com.bravin.shi.news.entity.ResponseEntity;
import com.bravin.shi.news.entity.UserEntity;
import com.bravin.shi.news.mapper.UserMapper;
import com.bravin.shi.news.rbo.RegisterByPhoneRBO;
import com.bravin.shi.news.util.BusinessUtil;
import com.bravin.shi.news.util.ResponseUtil;
import com.bravin.shi.news.util.SecurityUtil;
import com.bravin.shi.news.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    /**
     * 获取所有用户
     *
     * @return 用户列表
     */
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<UserEntity> listAllUsers() {
        List<UserEntity> users = userMapper.listAllUsers();
        return users;
    }

    /**
     * 根据id获取用户
     *
     * @param id 用户id
     * @return 用户
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public UserEntity getUser(@PathVariable("id") Long id) {
        UserEntity user = userMapper.getUser(id);
        return user;
    }

    /**
     * 创建用户
     *
     * @param user 用户信息
     */
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public void insert(@RequestBody UserEntity user) {
        userMapper.insert(user);
    }

    /**
     * 根据id删除用户
     *
     * @param id 用户id
     */
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long id) {
        userMapper.delete(id);
    }

    /**
     * 判断手机号是否已注册
     *
     * @param phoneNumber 手机号
     * @return 包含是否注册的response
     */
    @GetMapping(value = "/registered/{phoneNumber}")
    public ResponseEntity isRegistered(@PathVariable("phoneNumber") String phoneNumber) {
        String result = userMapper.isRegistered(phoneNumber);
        return ResponseUtil.success(result != null);
    }

    /**
     * 根据手机号注册用户
     *
     * @param rbo 包含手机号和验证码的请求对象
     * @return response
     */
    @PostMapping(value = "/register/phone")
    public ResponseEntity registerByPhone(@RequestBody RegisterByPhoneRBO rbo) {
        if (!StringUtil.isChinaPhoneLegal(rbo.getPhone())) {// 校验手机号
            return ResponseUtil.illegalParam("phone param is illegal!");
        }

        if (!StringUtil.isVerifyCode(rbo.getVerifyCode())) {// 校验验证码
            return ResponseUtil.illegalParam("verify code param is illegal!");
        }
        // 验证手机和验证码的一致性
        if (BusinessUtil.isPhoneVerifyCodeMatch(rbo.getPhone(), rbo.getVerifyCode())) {
            // 加密密码，获取密码的两次md5值作为存储的密码
            userMapper.registerByPhoneAndPassword(rbo.getPhone(),
                    SecurityUtil.getMD5Repeatedly(rbo.getPassword(), 2));
            return ResponseUtil.success();
        } else {
            return ResponseUtil.phoneVerifyCodeNotMatch();
        }
    }
}
