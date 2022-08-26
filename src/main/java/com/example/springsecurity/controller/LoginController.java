package com.example.springsecurity.controller;

import com.example.springsecurity.domain.ResponseResult;
import com.example.springsecurity.domain.User;
import com.example.springsecurity.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping ("/user/login")
    public ResponseResult login(@RequestBody User user){
        return loginService.login(user);
    }

    @RequestMapping("/user/logout")
    public ResponseResult logout() {
        return loginService.logout();
    }

}
