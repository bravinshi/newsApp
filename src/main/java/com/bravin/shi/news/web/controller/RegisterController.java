package com.bravin.shi.news.web.controller;

import com.bravin.shi.news.entity.UserEntity;
import com.bravin.shi.news.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class RegisterController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<UserEntity> listAllUsers(){
        List<UserEntity> users = userMapper.listAllUsers();
        return users;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public UserEntity getUser(@PathVariable("id") Long id){
        UserEntity user = userMapper.getUser(id);
        return user;
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public void insert(@RequestBody UserEntity user){
        userMapper.insert(user);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long id) {
        userMapper.delete(id);
    }
}
