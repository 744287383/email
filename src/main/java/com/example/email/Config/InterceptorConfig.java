package com.example.email.Config;

import com.example.email.Interceptor.CheckTokenLogin;
import com.example.email.Interceptor.LoadLoginUserInfoInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
@Autowired
private LoadLoginUserInfoInterceptor loadLoginUserInfoInterceptor;
@Autowired
private CheckTokenLogin checkTokenLogin;

    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration checkToken = registry.addInterceptor(checkTokenLogin);
        checkToken.addPathPatterns("/user/**");
        InterceptorRegistration interceptorRegistration = registry.addInterceptor(loadLoginUserInfoInterceptor);
        interceptorRegistration.addPathPatterns("/user/**");

    }
}
