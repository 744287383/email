package com.example.email.Controller;

import com.example.email.ModelDTO.LoginUser;
import com.example.email.ModelDTO.MessageInfoDTO;
import com.example.email.Service.MessageServiceIMP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class MsgController {
    @Autowired
    private MessageServiceIMP messageServiceIMP;
    @RequestMapping(value = "/user/getMsgInfo")
    public String getMsgInfo(@RequestParam("messageName")String messageName,
                             Model model, HttpSession session) throws IOException, MessagingException {
        LoginUser user = (LoginUser) session.getAttribute("user");
        MessageInfoDTO messgeInfoDTO = messageServiceIMP.getMessgeInfoDTO(user, messageName);
        model.addAttribute("messgeInfoDTO",messgeInfoDTO);
        return "minuteMsgView";
    }
}
