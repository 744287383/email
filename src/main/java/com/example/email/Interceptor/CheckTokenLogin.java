package com.example.email.Interceptor;

import com.example.email.ModelDTO.LoginUser;
import com.example.email.ModelDTO.StaffInfo;
import com.example.email.Service.StaffInfoServiceIMP;
import com.example.email.entity.Position;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class CheckTokenLogin implements HandlerInterceptor {
    @Autowired
    private StaffInfoServiceIMP staffInfoServiceIMP;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Cookie[] cookies = request.getCookies();
        Map<String, String> collect = Arrays.stream(cookies).collect(Collectors.toMap(cookie -> cookie.getName(), cookie -> cookie.getValue()));
        String token = collect.get("token");
        StaffInfo staffInfo = staffInfoServiceIMP.getStaffInfoByToken(token);
        if (null==staffInfo){
            return false;
        }
        LoginUser loginUser=new LoginUser();
        BeanUtils.copyProperties(staffInfo,loginUser);
        loginUser.setPositionName(staffInfo.getPositions().getPositionName());
        loginUser.setAuthorrityName(staffInfo.getAuthorrity().getAuthName());
        loginUser.setAuthid(staffInfo.getAuthorrity().getAuthId());
        loginUser.setPositionId(staffInfo.getPositionId());
        request.getSession().setAttribute("user",loginUser);

        return true;
    }
}
