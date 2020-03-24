package com.example.email.Interceptor;

import com.example.email.ModelDTO.LoginUser;
import com.example.email.Service.MessageServiceIMP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Component
public class UpdateNewMsgStatus implements HandlerInterceptor {
    @Autowired
    private MessageServiceIMP messageServiceIMP;
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        LoginUser user = (LoginUser) request.getSession().getAttribute("user");
        messageServiceIMP.updateNewMsgStatus(user);
    }
}
