package com.example.email.Controller;

import com.example.email.ModelDTO.LoginUser;
import com.example.email.ModelDTO.MinMessageDTO;
import com.example.email.Service.MessageServiceIMP;
import com.github.pagehelper.PageInfo;
import net.sf.jsqlparser.statement.create.table.Index;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
    @Value("${page.size}")
    private int size;

    @RequestMapping(value = "/user/recMsglist")
    public String recMsglist(@RequestParam(required = false,value = "indexPage",defaultValue = "1")int indexPage,
            HttpSession session, Model model){
        LoginUser loginUser = (LoginUser) session.getAttribute("user");
        PageInfo<MinMessageDTO> pageList = messageServiceIMP.getUserUndeleteMsgList(indexPage, size, loginUser);
        model.addAttribute("pageList",pageList);
        model.addAttribute("listmsg",pageList.getList());
        return "recMessageList";
    }
    @RequestMapping(value = "/user/deleteMsg")
    public String deleteMsg(@RequestParam("msgId")List<String> msgIdList,
                            @RequestParam("indexPage") int indexPage,
                            HttpSession session){
        LoginUser user = (LoginUser) session.getAttribute("user");
        messageServiceIMP.deleteMsgByMsgID(msgIdList,user);
        boolean deleteMSGPageNull = messageServiceIMP.isUndeleteMSGPageNull(user, indexPage, size);
        if (deleteMSGPageNull){
            if (indexPage>1)
            indexPage=indexPage-1;
        }
        return "redirect:/user/recMsglist?indexPage="+indexPage;
    }
    //收信箱上的彻底删除按钮业务处理
    @RequestMapping(value = "/user/deletedMsg")
    public String deletedMsg(@RequestParam("msgId")List<String> msgIdList,
                             @RequestParam("indexPage") int indexPage,
                            HttpSession session){
        LoginUser user = (LoginUser) session.getAttribute("user");
        messageServiceIMP.deletedMsgByMsgID(msgIdList,user);
        boolean deleteMSGPageNull = messageServiceIMP.isUndeleteMSGPageNull(user, indexPage, size);
        if (deleteMSGPageNull){
            if (indexPage>1)
                indexPage=indexPage-1;
        }
        return "redirect:/user/recMsglist?indexPage="+indexPage;
    }
    //回收站上的彻底删除按钮业务处理
    @RequestMapping(value = "/user/deletedMsgview")
    public String deletedMsgview(@RequestParam("msgId")List<String> msgIdList,
                             @RequestParam("indexPage") int indexPage,
                             HttpSession session){
        LoginUser user = (LoginUser) session.getAttribute("user");
        messageServiceIMP.deletedMsgByMsgID(msgIdList,user);
        boolean deleteMSGPageNull = messageServiceIMP.isDeleteMSGPageNull(user, indexPage, size);
        if (deleteMSGPageNull){
            if (indexPage>1)
                indexPage=indexPage-1;
        }
        return "redirect:/user/deletedMsgListView?indexPage="+indexPage;
    }

    @RequestMapping(value = "/user/readed")
    public String  readed(@RequestParam("msgId")List<String> msgIdList,
                          @RequestParam("indexPage") int indexPage,
                          HttpSession session){
        LoginUser user = (LoginUser) session.getAttribute("user");
        messageServiceIMP.readedMsg(user,msgIdList);
        return "redirect:/user/recMsglist?indexPage="+indexPage;
    }


    @RequestMapping(value = "/user/readedAll")
    public String  readedAll(HttpSession session,
                             @RequestParam("indexPage") int indexPage){
        LoginUser user = (LoginUser) session.getAttribute("user");
        messageServiceIMP.readedAllMsg(user);
        return "redirect:/user/recMsglist?indexPage="+indexPage;
    }

    @RequestMapping(value = "/user/deletedMsgListView")
    public String getDeletedMsgListView(@RequestParam(required = false,value = "indexPage",defaultValue = "1")int indexPage,
                                        HttpSession session, Model model){
        LoginUser loginUser = (LoginUser) session.getAttribute("user");
        PageInfo<MinMessageDTO> pageList = messageServiceIMP.getdeletedMsgList(indexPage,size , loginUser);
        model.addAttribute("pageList",pageList);
        model.addAttribute("listmsg",pageList.getList());
        return "deletedMsg";
    }
    @RequestMapping(value = "/user/reductionMsg")
    public String  reductionMsg(@RequestParam("msgId")List<String> msgIdList,
                          @RequestParam("indexPage") int indexPage,
                          HttpSession session){
        LoginUser user = (LoginUser) session.getAttribute("user");
        messageServiceIMP.reductionMsg(user,msgIdList);

        boolean deleteMSGPageNull = messageServiceIMP.isDeleteMSGPageNull(user, indexPage, size);
        if (deleteMSGPageNull){
            if (indexPage>1)
            indexPage=indexPage-1;
        }
        return "redirect:/user/deletedMsgListView?indexPage="+indexPage;
    }

    @RequestMapping(value = "/user/recordSenderMsgView")
    public String recordSenderMsgView(@RequestParam(required = false,value = "indexPage",defaultValue = "1")int indexPage,
                             HttpSession session, Model model){
        LoginUser loginUser = (LoginUser) session.getAttribute("user");
        PageInfo<MinMessageDTO> pageList = messageServiceIMP.recordSenderMsg(indexPage, size, loginUser);
        model.addAttribute("pageList",pageList);
        model.addAttribute("listmsg",pageList.getList());
        return "recordSenderMsg";
    }

    @RequestMapping(value = "/user/cleanSenderRecord")
    public String  cleanSenderRecord(@RequestParam("msgId")List<String> msgIdList,
                                     @RequestParam("indexPage") int indexPage,
                                     HttpSession session){
        LoginUser user = (LoginUser) session.getAttribute("user");
        messageServiceIMP.cleanSenderMSgRecord(msgIdList,user);
        boolean deleteMSGPageNull = messageServiceIMP.isSenderMSgRecordNull(user, indexPage, size);
        if (deleteMSGPageNull){
            if (indexPage>1)
                indexPage=indexPage-1;
        }
        return "redirect:/user/deletedMsgListView?indexPage="+indexPage;
    }
}
