package com.example.springsecurity.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springsecurity.domain.User;
import com.example.springsecurity.service.UserService;
import com.example.springsecurity.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author PC
* @description 针对表【sys_user(用户表)】的数据库操作Service实现
* @createDate 2022-08-24 16:12:26
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




