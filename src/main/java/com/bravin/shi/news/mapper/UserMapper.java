package com.bravin.shi.news.mapper;

import com.bravin.shi.news.entity.UserEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    /**
     * 插入新用户
     *
     * @param user 新用户的信息
     */
    void insert(UserEntity user);

    /**
     * 跟新用户
     *
     * @param user 新的用户信息
     */
    void update(UserEntity user);

    /**
     * 删除用户
     *
     * @param id 用户id
     */
    void delete(Long id);

    /**
     * 获取所有用户
     *
     * @return 用户集合
     */
    List<UserEntity> listAllUsers();

    /**
     * 获取用户
     *
     * @param id 用户id
     * @return 用户
     */
    UserEntity getUser(Long id);

    /**
     * 根据手机号判断用户是否已注册
     *
     * @param phoneNumber 手机号
     * @return 是否注册
     */
    String isRegistered(String phoneNumber);

    /**
     * 使用手机号注册
     *
     * @param phone 手机号
     */
    void registerByPhone(@Param("phone") String phone);

    /**
     * 使用手机号和密码注册
     *
     * @param phone 手机号
     */
    void registerByPhoneAndPassword(@Param("phone") String phone,
                                    @Param("password") String password);
}
