package com.bravin.shi.news.web.controller;

import com.bravin.shi.news.entity.ResponseEntity;
import com.bravin.shi.news.entity.UserEntity;
import com.bravin.shi.news.mapper.UserMapper;
import com.bravin.shi.news.rbo.RegisterByPhoneRBO;
import com.bravin.shi.news.util.ResponseUtil;
import com.bravin.shi.news.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<UserEntity> listAllUsers() {
        List<UserEntity> users = userMapper.listAllUsers();
        return users;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public UserEntity getUser(@PathVariable("id") Long id) {
        UserEntity user = userMapper.getUser(id);
        return user;
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public void insert(@RequestBody UserEntity user) {
        userMapper.insert(user);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long id) {
        userMapper.delete(id);
    }

    @GetMapping(value = "/registered/{phoneNumber}")
    public ResponseEntity isRegistered(@PathVariable("phoneNumber") String phoneNumber) {
        String result = userMapper.isRegistered(phoneNumber);
        return ResponseUtil.success(result != null);
    }

    @PostMapping(value = "/register/phone")
    public ResponseEntity registerByPhone(@RequestBody RegisterByPhoneRBO rbo) {
        if (!StringUtil.isChinaPhoneLegal(rbo.getPhone())) {// 校验手机号
            return ResponseUtil.illegalParam("phone param is illegal!");
        }
        if (!StringUtil.isVerifyCode(rbo.getVerifyCode())) {// 校验验证码
            return ResponseUtil.illegalParam("verify code param is illegal!");
        }

        // TODO 验证手机和验证码的一致性
        userMapper.registerByPhone(rbo.getPhone(), rbo.getVerifyCode());

        return ResponseUtil.success();
    }


}
