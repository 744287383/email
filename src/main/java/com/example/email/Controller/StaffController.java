package com.example.email.Controller;

import com.example.email.ModelDTO.LoginUser;
import com.example.email.ModelDTO.StaffInfo;
import com.example.email.Service.StaffInfoServiceIMP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class StaffController {
    @Autowired
    private StaffInfoServiceIMP staffInfoServiceIMP;
    @RequestMapping(value = "/user/updatePasswordView")
    public String updatePasswordView(){
        return "updatePassword";
    }

    @RequestMapping(value = "/user/updatePassword")
    @ResponseBody
    public Map<String,String> updatePassword(@RequestParam("cardNo")String cardNo,
                                             @RequestParam("nameAll")String nameAll
            , @RequestParam("password1")String password1
            , HttpSession session){
        Map<String,String> map=new HashMap<>();
        LoginUser user = (LoginUser) session.getAttribute("user");
        StaffInfo staffInfoByEmail = staffInfoServiceIMP.getStaffInfoByEmail(user.getEmail());
        if (!cardNo.equals(staffInfoByEmail.getCardNo())||!nameAll.equals(staffInfoByEmail.getNameall())){
            map.put("msg","身份证和姓名验证不成功！");
            return map;
        }
        staffInfoServiceIMP.updatePassword(user,password1);

    map.put("msg","密码修改成功，下次登录请使用新密码登录！");
    return map;
    }

    //通讯录视图获取
    @RequestMapping("/user/getMailBookView")
    public String getMailBookView(){

        return "mailBook";
    }
}
