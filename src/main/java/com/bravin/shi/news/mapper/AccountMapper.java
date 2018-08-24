package com.bravin.shi.news.mapper;

public interface AccountMapper {
    /**
     * 根据手机号判断用户是否已注册
     *
     * @param phoneNumber 手机号
     * @return 是否注册
     */
    String isRegistered(String phoneNumber);
}
