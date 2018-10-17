package com.bravin.shi.news.entity.to;

import com.bravin.shi.news.entity.UserEntity;

public class RegisterTO {
    private String sessionToken;
    private UserEntity user;

    public String getSessionToken() {
        return sessionToken;
    }

    public void setSessionToken(String sessionToken) {
        this.sessionToken = sessionToken;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
