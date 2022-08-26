package com.example.springsecurity.mapper;

import com.example.springsecurity.domain.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author PC
* @description 针对表【sys_user(用户表)】的数据库操作Mapper
* @createDate 2022-08-24 16:12:26
* @Entity com.example.springsecurity.domain.User
*/
@Mapper
public interface UserMapper extends BaseMapper<User> {

}




