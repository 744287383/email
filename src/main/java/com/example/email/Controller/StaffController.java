package com.example.email.Controller;

import com.example.email.Enum.FriendGroupStatus;
import com.example.email.Enum.StaffStatus;
import com.example.email.ModelDTO.LoginUser;
import com.example.email.ModelDTO.StaffInfo;
import com.example.email.ModelDTO.StaffListDTO;
import com.example.email.Service.*;
import com.example.email.entity.Dept;
import com.example.email.entity.FriendGroup;
import com.example.email.entity.Staff;
import com.example.email.entity.Users;
import com.example.email.test.POP3Client;
import com.example.email.test.StaffUtills;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.mail.Session;
import javax.servlet.http.HttpSession;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
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
    @Autowired
    private UsersServiceIMP usersServiceIMP;
    @Autowired
    private FriendGroupServiceIMP friendGroupServiceIMP;
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




    @RequestMapping(value = "/user/admin/getStaffListView")
    public String getStaffListView(@RequestParam(required = false,value = "indexPage",defaultValue = "1")int indexPage,
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

    @RequestMapping(value = "/user/deleteStaff")
    @ResponseBody
    public Map<String,String> deleteStaff(@RequestParam(value = "username")String username){
        Map<String,String> result=new HashMap<>();
        Staff staff=new Staff();
        staff.setUserName(username);
        staff.setStatus(StaffStatus.QUIT.getStatus());
        staffInfoServiceIMP.updateStaffByUserName(staff);
        result.put("msg","成功辞退该员工！");
        return result;
    }
    @RequestMapping(value = "/user/admin/getAddStaffView")
    public String getAddStaffView(Model model){
        List<Dept> alLDept = deptInfoServiceIMP.getAlLDept();
        model.addAttribute("depts",alLDept);
        return "addStaffView";
    }

    @RequestMapping(value = "/user/admin/addStaff")
    @ResponseBody
    public Map<String,String> addStaff(Staff staff) throws NoSuchAlgorithmException {
        Map<String,String> result=new HashMap<>();
        String username= StaffUtills.getUserName(staff.getNameall(),staff.getCardNo());
        String password=StaffUtills.getPassword(staff.getCardNo());
        String email=StaffUtills.getEmail(username);
        staff.setUserName(username);
        staff.setEmail(email);
        staff.setEmailPassword(password);
        staff.setLoginPassword(password);
        staff.setStatus(StaffStatus.UNQUIT.getStatus());
        staff.setStartTime(new Date(System.currentTimeMillis()));
        staff.setLoginTime(new Date(System.currentTimeMillis()));
        staff.setImgUrl("http://test.com:8080/images/tx.png");
        Users users=new Users();
        users.setUsername(username);
        users.setPwdhash(POP3Client.digestString(password,"SHA"));
        users.setPwdalgorithm("SHA");
        users.setUseforwarding((short) 0);
        users.setUsealias((short) 0);
        StaffInfo staffInfoByUsername = staffInfoServiceIMP.getStaffInfoByUsername(username);
        if (null!=staffInfoByUsername){
            result.put("msg","该员工已经是公司的员工！请勿重复添加！");
            return result;
        }
        usersServiceIMP.addUsers(users);
        staffInfoServiceIMP.addStaff(staff);
        result.put("msg","员工添加成功，工号为姓名首字母加身份证后6位，密码位身份证后6位！");
        FriendGroup friendGroup=new FriendGroup();
        friendGroup.setDefaultGroup(FriendGroupStatus.DEFAULT.getStatus());
        friendGroup.setUserName(username);
        friendGroup.setGroupName("默认好友");
        friendGroupServiceIMP.addFriendGrop(friendGroup);
        return result;
    }
    @RequestMapping(value = "/user/admin/updateStaff")
    @ResponseBody
    public Map<String,String> updateStaff(Staff staff){
        Map<String,String> result=new HashMap<>();
        staffInfoServiceIMP.updateStaffByUserName(staff);
        result.put("msg","成功修改员工信息！");
        return result;
    }
    @RequestMapping(value = "/user/admin/getUpdateStaffView")
    public String getUpdateStaffView(@RequestParam("username") String username,Model model){
        Staff staff=staffInfoServiceIMP.getStaffByUsername(username);
        model.addAttribute("staff",staff);
        List<Dept> alLDept = deptInfoServiceIMP.getAlLDept();
        model.addAttribute("depts",alLDept);

    return "addStaffView";
    }

    @RequestMapping(value = "/user/v3/getStaffListView")
    public String getStaffListView1(@RequestParam(required = false,value = "indexPage",defaultValue = "1")int indexPage,
                                   HttpSession session, Model model,
                                   @RequestParam(required = false,value = "deptNo",defaultValue = "0")int deptNo){
        LoginUser loginUser = (LoginUser) session.getAttribute("user");

        PageInfo<StaffListDTO> pageList=  staffInfoServiceIMP.getStaffListDTO(indexPage, size, loginUser,loginUser.getDeptNo());

        model.addAttribute("pageList",pageList);
        model.addAttribute("deptNo",deptNo);
        return "v2StaffView";
    }
    @RequestMapping(value = "/user/v3/getAddDeptStaffView")
    public String getAddDeptStaffView(Model model){
        List<Dept> alLDept = deptInfoServiceIMP.getAlLDept();
        model.addAttribute("depts",alLDept);
        return "addDeptStaffView";
    }


    @RequestMapping(value = "/user/V3/addDeptStaff")
    @ResponseBody
    public Map<String,String> addDeptStaff(Staff staff,HttpSession session) throws NoSuchAlgorithmException {
        LoginUser user = (LoginUser) session.getAttribute("user");
        Map<String,String> result=new HashMap<>();
        String username= StaffUtills.getUserName(staff.getNameall(),staff.getCardNo());
        String password=StaffUtills.getPassword(staff.getCardNo());
        String email=StaffUtills.getEmail(username);
        staff.setUserName(username);
        staff.setEmail(email);
        staff.setEmailPassword(password);
        staff.setLoginPassword(password);
        staff.setDeptNo(user.getDeptNo());
        staff.setStatus(StaffStatus.UNQUIT.getStatus());
        staff.setStartTime(new Date(System.currentTimeMillis()));
        staff.setLoginTime(new Date(System.currentTimeMillis()));
        staff.setImgUrl("http://test.com:8080/images/tx.png");
        Users users=new Users();
        users.setUsername(username);
        users.setPwdhash(POP3Client.digestString(password,"SHA"));
        users.setPwdalgorithm("SHA");
        users.setUseforwarding((short) 0);
        users.setUsealias((short) 0);
        StaffInfo staffInfoByUsername = staffInfoServiceIMP.getStaffInfoByUsername(username);
        if (null!=staffInfoByUsername){
            result.put("msg","该员工已经是公司的员工！请勿重复添加！");
            return result;
        }
        usersServiceIMP.addUsers(users);
        staffInfoServiceIMP.addStaff(staff);
        result.put("msg","员工添加成功，工号为姓名首字母加身份证后6位，密码位身份证后6位！");
        FriendGroup friendGroup=new FriendGroup();
        friendGroup.setDefaultGroup(FriendGroupStatus.DEFAULT.getStatus());
        friendGroup.setUserName(username);
        friendGroup.setGroupName("默认好友");
        friendGroupServiceIMP.addFriendGrop(friendGroup);
        return result;
    }
    @RequestMapping(value = "/user/v3/getUpdateDeptStaffView")
    public String getUpdateDeptStaffView(@RequestParam("username") String username,Model model){
        Staff staff=staffInfoServiceIMP.getStaffByUsername(username);
        model.addAttribute("staff",staff);

        return "addDeptStaffView";
    }
    @RequestMapping(value ="/user/getUpdateProfile")
    public String getUpdateProfile(HttpSession session,Model model){
        LoginUser user = (LoginUser) session.getAttribute("user");
        Staff staff=staffInfoServiceIMP.getStaffByUsername(user.getUserName());
        String cardNo = staff.getCardNo();
        String substring = cardNo.substring(0,4);
        String substring1 = cardNo.substring(cardNo.length() - 4, cardNo.length());
        String str=substring+"**********"+substring1;
        staff.setCardNo(str);
        model.addAttribute("staff",staff);
        return "updateProfile";
    }
    @RequestMapping(value = "/user/updateDeptStaff")
    @ResponseBody
    public Map<String,String> updateDeptStaff(Staff staff){
        Map<String,String> result=new HashMap<>();
        staffInfoServiceIMP.updateStaffByUserName(staff);
        result.put("msg","个人信息修改成功！");
        return result;
    }

}
