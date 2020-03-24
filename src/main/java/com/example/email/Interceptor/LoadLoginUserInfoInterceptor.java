package com.example.email.Interceptor;

import com.example.email.ModelDTO.LoginUser;
import com.example.email.ModelDTO.MessageCountDTO;
import com.example.email.Service.DraftServiceImp;
import com.example.email.Service.MessageServiceIMP;
import org.springframework.aop.AfterAdvice;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private MessageServiceIMP messageServiceIMP;
    @Autowired
    private DraftServiceImp draftServiceImp;
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        LoginUser user = (LoginUser) request.getSession().getAttribute("user");


        if (null!=modelAndView)
        modelAndView.addObject("loginUser",user);
        response.addCookie(new Cookie("name","name"));

        MessageCountDTO messageCountDTO=new MessageCountDTO();
        Long draftCount = draftServiceImp.getDraftCount(user);
        messageCountDTO.setDraftCount(draftCount);
        long userUnreadMessageCount = messageServiceIMP.getUserUnreadMessageCount(user);
        messageCountDTO.setUnReadMsgCount(userUnreadMessageCount);
        long userNewMessageCount = messageServiceIMP.getUserNewMessageCount(user);
        messageCountDTO.setNewMsgCount(userNewMessageCount);
        long SendedMsgCount=messageServiceIMP.getSendedMsgCount(user);
        messageCountDTO.setSendedMsgCount(SendedMsgCount);
        long deleteMsgCount= messageServiceIMP.getdeleteMsgCount(user);
        messageCountDTO.setDeleteMsgCount(deleteMsgCount);
        if (null!=modelAndView)
            modelAndView.addObject("messageCountDTO",messageCountDTO);
    }
}
