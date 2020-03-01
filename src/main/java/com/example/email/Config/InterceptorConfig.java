package com.example.email.Config;

import com.example.email.Interceptor.CheckTokenLogin;
import com.example.email.Interceptor.LoadLoginUserInfoInterceptor;
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
@Value("${imgUri}")
private String imgPath;
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration checkToken = registry.addInterceptor(checkTokenLogin);
        checkToken.addPathPatterns("/user/**");
        InterceptorRegistration interceptorRegistration = registry.addInterceptor(loadLoginUserInfoInterceptor);
        interceptorRegistration.addPathPatterns("/user/**");

    }

    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        System.out.println(imgPath);
        registry.addResourceHandler("/file/**").addResourceLocations("file:/"+imgPath);
    }
}
