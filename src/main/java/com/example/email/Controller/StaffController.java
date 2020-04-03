package com.example.email.Controller;

import com.example.email.Enum.StaffStatus;
import com.example.email.ModelDTO.LoginUser;
import com.example.email.ModelDTO.PositionListDTO;
import com.example.email.ModelDTO.StaffInfo;
import com.example.email.ModelDTO.StaffListDTO;
import com.example.email.Service.DeptInfoServiceIMP;
import com.example.email.Service.PositionServiceImp;
import com.example.email.Service.StaffInfoServiceIMP;
import com.example.email.entity.Dept;
import com.example.email.entity.Staff;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class StaffController {
    @Value("${page.size}")
    private int size;
    @Autowired
    private DeptInfoServiceIMP deptInfoServiceIMP;
    @Autowired
    private PositionServiceImp positionServiceImp;
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


    @RequestMapping(value = "/user/admin/getStaffListView")
    public String getPositionView(@RequestParam(required = false,value = "indexPage",defaultValue = "1")int indexPage,
                                  HttpSession session, Model model,
                                  @RequestParam(required = false,value = "deptNo",defaultValue = "0")int deptNo){
        LoginUser loginUser = (LoginUser) session.getAttribute("user");
        List<Dept> alLDept = deptInfoServiceIMP.getAlLDept();
        if (deptNo==0){

            model.addAttribute("depts",alLDept);
            PageInfo<StaffListDTO> pageList=  staffInfoServiceIMP.getStaffListDTO(indexPage, size, loginUser);
            model.addAttribute("pageList",pageList);
            model.addAttribute("deptNo",deptNo);
            return "staffListView";
        }
        PageInfo<StaffListDTO> pageList=  staffInfoServiceIMP.getStaffListDTO(indexPage, size, loginUser,deptNo);
        model.addAttribute("depts",alLDept);
        model.addAttribute("pageList",pageList);
        model.addAttribute("deptNo",deptNo);
        return "staffListView";
    }

    @RequestMapping(value = "/user/admin/deleteStaff")
    @ResponseBody
    public Map<String,String> updateDept(@RequestParam(value = "username")String username){
        Map<String,String> result=new HashMap<>();
        Staff staff=new Staff();
        staff.setUserName(username);
        staff.setStatus(StaffStatus.QUIT.getStatus());
        staffInfoServiceIMP.updateStaffByUserName(staff);
        result.put("msg","成功辞退该员工！");
        return result;
    }
}
