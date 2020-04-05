package com.example.email.Controller;

import com.example.email.ModelDTO.DraftDTO;
import com.example.email.ModelDTO.LoginUser;
import com.example.email.ModelDTO.MassageDTO;
import com.example.email.ModelDTO.MessageInfoDTO;
import com.example.email.Service.EmailSenderServiceIMP;
import com.example.email.Service.StaffInfoServiceIMP;
import com.example.email.entity.Draft;
import com.example.email.entity.Message;
import com.example.email.entity.Staff;
import org.apache.catalina.User;
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
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class MailSenderController {
    @Autowired
    private EmailSenderServiceIMP emailSenderServiceIMP;
    @Autowired
    private StaffInfoServiceIMP staffInfoServiceIMP;
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

    @RequestMapping(value = "/user/getGroupSender")
    public String getGroupSender(@RequestParam(value = "email",required = false)String email, Model model){
        DraftDTO draftDTO=new DraftDTO();
        draftDTO.setRecipients(email);
        model.addAttribute("draftDTO",draftDTO);
        return "groupSenderView";
    }
    @RequestMapping(value = "/user/groupSender")

    public String groupSender(MassageDTO massageDTO,
                              @RequestParam("handleType")int handleType,
                              HttpSession session, @RequestParam("file")MultipartFile file) throws MessagingException {
        LoginUser loginUser = (LoginUser) session.getAttribute("user");

        if (handleType==1){
            String[] to = massageDTO.getTo().split(";");
            emailSenderServiceIMP.groupSenderEmail(loginUser,to,massageDTO,file);
        }
        if (handleType==2){
            Long deptNo = loginUser.getDeptNo();
          List<Staff> staffs=staffInfoServiceIMP.getStaffByDeptNo(loginUser.getUserName(),deptNo);
            List<String> collect = staffs.stream().map(staff -> staff.getEmail()).collect(Collectors.toList());
            String[] tos = new String[collect.size()];
            collect.toArray(tos);
            if (null==tos||tos.length==0){
                return "redirect:/user/recordSenderMsgView";
            }
            emailSenderServiceIMP.groupSenderEmail(loginUser,tos,massageDTO,file);
        }
        if (handleType==3){
            List<Staff> staffs=staffInfoServiceIMP.getStaffAll(loginUser.getUserName());
            List<String> collect = staffs.stream().map(staff -> staff.getEmail()).collect(Collectors.toList());
            String[] tos = new String[collect.size()];
            collect.toArray(tos);
            if (null==tos||tos.length==0){
                return "redirect:/user/recordSenderMsgView";
            }
            emailSenderServiceIMP.groupSenderEmail(loginUser,tos,massageDTO,file);
        }

        return "redirect:/user/recordSenderMsgView";
    }
}
