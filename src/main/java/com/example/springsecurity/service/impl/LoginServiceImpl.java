package com.example.springsecurity.service.impl;

import com.example.springsecurity.domain.LoginUser;
import com.example.springsecurity.domain.ResponseResult;
import com.example.springsecurity.domain.User;
import com.example.springsecurity.service.LoginService;
import com.example.springsecurity.utils.JwtUtil;
import com.example.springsecurity.utils.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Objects;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private RedisCache redisCache;

    @Override
    public ResponseResult login(User user) {
        //用户认证
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword());
        Authentication authenticate = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        //认证没通过给对应的提示
        if (Objects.isNull(authenticate)){
            throw new RuntimeException("登陆失败");
        }
        //认证通过 userid生成jwt 将jwt返回
        LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
        String userId = loginUser.getUser().getId().toString();
        String jwt = JwtUtil.createJWT(userId);
        HashMap<String, String> res = new HashMap<>();
        res.put("token",jwt);
        //将用户信息存入redis
        redisCache.setCacheObject("login:" + userId ,loginUser);
        return new ResponseResult(200,"登陆成功",res);
    }

    @Override
    public ResponseResult logout() {
        //获取SecurityContextHolder中的用户ID
        UsernamePasswordAuthenticationToken authentication = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        Long id = loginUser.getUser().getId();
        //删除redis中的用户信息
        String redisKey = "login:" + id;
        redisCache.deleteObject(redisKey);
        return new ResponseResult(200,"注销成功");
    }
}
