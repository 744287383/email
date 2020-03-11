package com.example.email.Controller;

import com.example.email.ModelDTO.LoginUser;
import com.example.email.ModelDTO.MinMessageDTO;
import com.example.email.Service.MessageServiceIMP;
import com.github.pagehelper.PageInfo;
import net.sf.jsqlparser.statement.create.table.Index;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class RecMsgController {
    @Autowired
    private MessageServiceIMP messageServiceIMP;
    @RequestMapping(value = "/user/recMsglist")
    public String recMsglist(@RequestParam(required = false,value = "indexPage",defaultValue = "1")int indexPage,
            @RequestParam(required = false,value = "size",defaultValue = "1")int size,
            HttpSession session, Model model){
        LoginUser loginUser = (LoginUser) session.getAttribute("user");
        PageInfo<MinMessageDTO> pageList = messageServiceIMP.getUserUndeleteMsgList(indexPage, size, loginUser);
        model.addAttribute("pageList",pageList);
        model.addAttribute("listmsg",pageList.getList());
        return "recMessageList";
    }
    @RequestMapping(value = "/user/deleteMsg")
    public String deleteMsg(@RequestParam("msgId")List<String> msgIdList,
                            HttpSession session){
        LoginUser user = (LoginUser) session.getAttribute("user");
        messageServiceIMP.deleteMsgByMsgID(msgIdList,user);
        return "redirect:/user/recMsglist";
    }

    @RequestMapping(value = "/user/deletedMsg")
    public String deletedMsg(@RequestParam("msgId")List<String> msgIdList,
                            HttpSession session){
        LoginUser user = (LoginUser) session.getAttribute("user");
        messageServiceIMP.deletedMsgByMsgID(msgIdList,user);
        return "redirect:/user/recMsglist";
    }

    @RequestMapping(value = "/user/readed")
    public String  readed(@RequestParam("msgId")List<String> msgIdList,
                          HttpSession session){
        LoginUser user = (LoginUser) session.getAttribute("user");
        messageServiceIMP.readedMsg(user,msgIdList);
        return "redirect:/user/recMsglist";
    }

    @RequestMapping(value = "/user/readedAll")
    public String  readedAll(HttpSession session){
        LoginUser user = (LoginUser) session.getAttribute("user");
        messageServiceIMP.readedAllMsg(user);
        return "redirect:/user/recMsglist";
    }
}
