package com.example.email.Service;

import com.example.email.ModelDTO.LoginUser;
import com.example.email.ModelDTO.MassageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.List;
import java.util.Properties;

@Service
public class EmailSenderServiceIMP {
    @Qualifier("addJavaMailSenderImpl")
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
        helper.setText(massageDTO.getText(),true);
        if (!file.isEmpty())
        helper.addAttachment(file.getOriginalFilename(),file);

        javaMailSender.send(message);
    }

    public void groupSenderEmail(LoginUser loginUser, String[] rec, MassageDTO massageDTO, MultipartFile file) throws MessagingException {
        javaMailSender.setUsername(loginUser.getUserName());
        javaMailSender.setPassword(loginUser.getEmailPassword());

        MimeMessage message=javaMailSender.createMimeMessage();
        MimeMessageHelper helper=new MimeMessageHelper(message,true);

        helper.setFrom(loginUser.getEmail());
        helper.setTo(rec);
        helper.setSubject(massageDTO.getSubject());
        helper.setText(massageDTO.getText(),true);
        if (!file.isEmpty())
            helper.addAttachment(file.getOriginalFilename(),file);
        javaMailSender.send(message);
    }
}
