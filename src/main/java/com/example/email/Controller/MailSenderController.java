package com.example.email.Controller;

import com.example.email.ModelDTO.DraftDTO;
import com.example.email.ModelDTO.LoginUser;
import com.example.email.ModelDTO.MassageDTO;
import com.example.email.Service.EmailSenderServiceIMP;
import com.example.email.entity.Draft;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
    @RequestMapping(value = "/user/write")
    public String getindexview(@RequestParam(value = "email",required = false)String email, Model model){
        DraftDTO draftDTO=new DraftDTO();
        draftDTO.setRecipients(email);
        model.addAttribute("draftDTO",draftDTO);
        return "write";
    }

    @RequestMapping(value = "/user/emailsender")

    public String senderEmail(MassageDTO massageDTO,
                              HttpSession session, @RequestParam("file")MultipartFile file) throws MessagingException {
        LoginUser loginUser = (LoginUser) session.getAttribute("user");
        emailSenderServiceIMP.senderEmail(loginUser,massageDTO,file);
        return "redirect:/user/recordSenderMsgView";
    }


}
