package com.example.email.Interceptor;

import com.example.email.ModelDTO.LoginUser;
import com.example.email.Service.DraftServiceImp;
import com.example.email.mapper.DraftMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Component
public class DeleteDrafrtInterceptor implements HandlerInterceptor {
    @Autowired
    private DraftServiceImp draftServiceImp;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        LoginUser user = (LoginUser) request.getSession().getAttribute("user");
        String Id = request.getParameter("DId");
        if (null!=Id){

            draftServiceImp.deleteDraftByid(user, Integer.parseInt(Id));
        }

        return true;
    }
}
