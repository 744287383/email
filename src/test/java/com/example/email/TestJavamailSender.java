package com.example.email;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestJavamailSender {
    @Autowired
    private JavaMailSender javaMailSender;
    @Test
    public void testsender(){
        JavaMailSenderImpl javamailsenderImpl= (JavaMailSenderImpl) javaMailSender;
        javamailsenderImpl.setUsername("test1");
        javamailsenderImpl.setPassword("123456");
        SimpleMailMessage simpleMailMessage=new SimpleMailMessage();
        simpleMailMessage.setFrom("test1@test.com");
        simpleMailMessage.setTo("test2@test.com");
        simpleMailMessage.setSubject("这是测试的发送邮件");
        simpleMailMessage.setText("这是测试邮件的内容");
        FileSystemResource attachment = new FileSystemResource(new File("C:\\Users\\czz\\Desktop\\11.png"));
        javamailsenderImpl.send(simpleMailMessage);
    }
}
