package com.example.email.Interceptor;

import com.example.email.ModelDTO.LoginUser;
import org.springframework.aop.AfterAdvice;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.logging.Handler;
@Component
public class LoadLoginUserInfoInterceptor implements HandlerInterceptor {

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        LoginUser user = (LoginUser) request.getSession().getAttribute("user");
        if (null!=modelAndView)
        modelAndView.addObject("loginUser",user);
        response.addCookie(new Cookie("name","name"));
    }
}
