package com.example.springsecurity.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springsecurity.domain.Menu;
import com.example.springsecurity.service.MenuService;
import com.example.springsecurity.mapper.MenuMapper;
import org.springframework.stereotype.Service;

/**
* @author PC
* @description 针对表【sys_menu(菜单权限表)】的数据库操作Service实现
* @createDate 2022-08-25 20:58:50
*/
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu>
    implements MenuService{

}




