package com.bravin.shi.news.web.controller;

import com.bravin.shi.news.entity.ResponseEntity;
import com.bravin.shi.news.mapper.AccountMapper;
import com.bravin.shi.news.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountMapper accountMapper;

    @RequestMapping(value = "/registered/{phoneNumber}", method = RequestMethod.GET)
    public ResponseEntity isRegistered(@PathVariable("phoneNumber") String phoneNumber){
        String result = accountMapper.isRegistered(phoneNumber);
        return ResponseUtil.success(result != null);
    }
}
