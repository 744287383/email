package com.example.email.Config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class BeanConfig {
    @Value("${spring.mail.host}")
    private String host;
    @Value("${spring.mail.port}")
    private int   port;
    @Value("${spring.mail.default-encoding}")
    private String encode;
    @Value("${spring.mail.properties.mail.smtp.auth}")
    private String auth;
    @Bean
    @Scope("prototype")
    public JavaMailSenderImpl addJavaMailSenderImpl(){

        JavaMailSenderImpl javaMailSender=new JavaMailSenderImpl();
        javaMailSender.setHost(host);
        javaMailSender.setPort(port);
        javaMailSender.setDefaultEncoding(encode);
        javaMailSender.getJavaMailProperties().setProperty("mail.smtp.auth",auth);
        return javaMailSender;
    }
}
