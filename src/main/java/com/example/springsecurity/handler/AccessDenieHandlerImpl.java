package com.example.springsecurity.handler;

import com.alibaba.fastjson.JSON;
import com.example.springsecurity.domain.ResponseResult;
import com.example.springsecurity.utils.WebUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AccessDenieHandlerImpl implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        //处理异常
        ResponseResult result = new ResponseResult(HttpStatus.FORBIDDEN.value(),"权限不足");
        String json = JSON.toJSONString(result);
        WebUtils.renderString(response,json);
    }

}
