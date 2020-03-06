package com.example.email.Controller;

import com.example.email.ModelDTO.LoginUser;
import com.example.email.ModelDTO.MassageDTO;
import com.example.email.Service.EmailSenderServiceIMP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.Email;

@Controller
public class MailSenderController {
    @Autowired
    private EmailSenderServiceIMP emailSenderServiceIMP;

    @RequestMapping(value = "/user/emailsender")
    @ResponseBody
    public String senderEmail(MassageDTO massageDTO,
                              HttpSession session, @RequestParam("file")MultipartFile file) throws MessagingException {
        LoginUser loginUser = (LoginUser) session.getAttribute("user");
        emailSenderServiceIMP.senderEmail(loginUser,massageDTO,file);
        return "success";
    }


}
