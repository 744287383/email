package com.example.email.Config;

import com.example.email.Interceptor.CheckTokenLogin;
import com.example.email.Interceptor.DeleteDrafrtInterceptor;
import com.example.email.Interceptor.LoadLoginUserInfoInterceptor;
import com.example.email.Interceptor.UpdateNewMsgStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

import java.util.ArrayList;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
@Autowired
private LoadLoginUserInfoInterceptor loadLoginUserInfoInterceptor;
@Autowired
private CheckTokenLogin checkTokenLogin;
@Autowired
private DeleteDrafrtInterceptor deleteDrafrtInterceptor;
@Autowired
private UpdateNewMsgStatus updateNewMsgStatus;
@Value("${imgUri}")
private String imgPath;
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration checkToken = registry.addInterceptor(checkTokenLogin);
        checkToken.addPathPatterns("/user/**");
        InterceptorRegistration interceptorRegistration = registry.addInterceptor(loadLoginUserInfoInterceptor);
        interceptorRegistration.addPathPatterns("/user/**");
        InterceptorRegistration interceptorRegistration1 = registry.addInterceptor(deleteDrafrtInterceptor);
        interceptorRegistration1.addPathPatterns("/user/emailsender");
        InterceptorRegistration interceptorRegistration2 = registry.addInterceptor(updateNewMsgStatus);
        interceptorRegistration2.addPathPatterns("/user/recMsglist");

    }

    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        System.out.println(imgPath);
        registry.addResourceHandler("/file/**").addResourceLocations("file:/"+imgPath);
    }
}
