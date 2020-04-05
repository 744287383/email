package com.example.email.Controller;

import com.alibaba.druid.sql.visitor.functions.If;
import com.example.email.Enum.ReadStatus;
import com.example.email.ModelDTO.LoginUser;
import com.example.email.ModelDTO.MessageInfoDTO;
import com.example.email.Service.MessageServiceIMP;
import com.example.email.entity.Message;
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
                             @RequestParam(value = "type",defaultValue ="0'")int type,
                             Model model, HttpSession session) throws IOException, MessagingException {
        LoginUser user = (LoginUser) session.getAttribute("user");
        if (type==1){
            Message message=new Message();
            message.setMessageName(messageName);
            message.setReaded(ReadStatus.READED.getStatus());
            messageServiceIMP.updateMessage(user,message);
        }
        MessageInfoDTO messgeInfoDTO = messageServiceIMP.getMessgeInfoDTO(user, messageName);
        model.addAttribute("messgeInfoDTO",messgeInfoDTO);
        return "minuteMsgView";
    }
}
