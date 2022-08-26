package com.example.springsecurity.mapper;

import com.example.springsecurity.domain.Menu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author PC
* @description 针对表【sys_menu(菜单权限表)】的数据库操作Mapper
* @createDate 2022-08-25 20:58:50
* @Entity com.example.springsecurity.domain.Menu
*/
@Mapper
public interface MenuMapper extends BaseMapper<Menu> {

    List<String> selectPermsByUserId(Long userId);

}




