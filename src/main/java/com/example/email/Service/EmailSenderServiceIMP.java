package com.example.email.Service;

import com.example.email.ModelDTO.LoginUser;
import com.example.email.ModelDTO.MassageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class EmailSenderServiceIMP {
    @Autowired
    private JavaMailSenderImpl javaMailSender;
    public void senderEmail(LoginUser loginUser, MassageDTO massageDTO, MultipartFile file) throws MessagingException {
        javaMailSender.setUsername(loginUser.getUserName());
        javaMailSender.setPassword(loginUser.getEmailPassword());
        MimeMessage message=javaMailSender.createMimeMessage();
        MimeMessageHelper helper=new MimeMessageHelper(message,true);
        helper.setFrom(loginUser.getEmail());
        helper.setTo(massageDTO.getTo());
        helper.setSubject(massageDTO.getSubject());
        helper.setText(massageDTO.getText());
        helper.addAttachment(file.getOriginalFilename(),file);
        javaMailSender.send(message);
    }

}
