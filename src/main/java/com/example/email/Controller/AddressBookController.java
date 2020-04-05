package com.example.email.Controller;

import com.example.email.Enum.FriendGroupStatus;
import com.example.email.ModelDTO.FriendGroupListDTO;
import com.example.email.ModelDTO.LoginUser;
import com.example.email.ModelDTO.StaffInfo;
import com.example.email.Service.FriendGroupServiceIMP;
import com.example.email.Service.StaffInfoServiceIMP;
import com.example.email.entity.AddressBook;
import com.example.email.entity.Dept;
import com.example.email.entity.FriendGroup;
import com.example.email.entity.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class AddressBookController {
    @Autowired
    private FriendGroupServiceIMP friendGroupServiceIMP;
    @Autowired
    private StaffInfoServiceIMP staffInfoServiceIMP;
    //通讯录视图获取
    @RequestMapping("/user/getMailBookView")
    public String getMailBookView(HttpSession session, Model model){
        LoginUser user = (LoginUser) session.getAttribute("user");
        List<FriendGroupListDTO> dtos= friendGroupServiceIMP.getAllFriendGroupList(user.getUserName());
        model.addAttribute("dtos",dtos);

        List<FriendGroup> friendGroups=friendGroupServiceIMP.getFriendGroups(user.getUserName());
        model.addAttribute("friendGroups",friendGroups);
        return "mailBook";
    }
    @RequestMapping(value = "/user/addFriendGroup")
    @ResponseBody
    public Map<String,Object> addFriendGroup(@RequestParam("groupname")String groupname,HttpSession session){
        Map<String,Object> result=new HashMap<>();
        LoginUser user = (LoginUser) session.getAttribute("user");
        FriendGroup friendGroup=friendGroupServiceIMP.getFriendGroup(user.getUserName(),groupname);
        if (null!=friendGroup){
            result.put("msg","该分组已经存在，请勿重复添加！");
            return result;
        }
        friendGroup=new FriendGroup();
        friendGroup.setGroupName(groupname);
        friendGroup.setUserName(user.getUserName());
        friendGroup.setDefaultGroup(FriendGroupStatus.UNDEFAULT.getStatus());
        friendGroupServiceIMP.addFriendGrop(friendGroup);
        result.put("msg","分组添加成功！");
        return result;
    }
    @RequestMapping(value = "/user/deleteFriendGroup")
    @ResponseBody
    public Map<String,Object> deleteFriendGroup(@RequestParam("groupid")long groupid,HttpSession session){
        Map<String,Object> result=new HashMap<>();
        LoginUser user = (LoginUser) session.getAttribute("user");
        FriendGroup friendGroup=friendGroupServiceIMP.getFriendGroup(user.getUserName(),groupid);
        if (null!=friendGroup&&friendGroup.getDefaultGroup()==FriendGroupStatus.DEFAULT.getStatus()){
            result.put("msg","该分组默认分组，不可以删除！");
            return result;
        }
        List<AddressBook> addressBooks=friendGroupServiceIMP.getAdressBook(groupid);
        if (null!=addressBooks&&addressBooks.size()!=0){
            result.put("msg","该分组分组中存在联系人，不可以删除！");
            return result;
        }
        friendGroupServiceIMP.deleteFriendGroup(groupid);

        result.put("msg","分组删除成功！");
        return result;
    }
    @RequestMapping(value = "/user/updateFriendGroup")
    @ResponseBody
    public Map<String,Object> updateFriendGroup(@RequestParam("groupname")String groupname,
                                                @RequestParam("groupid")long groupId
            ,HttpSession session){
        Map<String,Object> result=new HashMap<>();
        LoginUser user = (LoginUser) session.getAttribute("user");
        FriendGroup friendGroup=friendGroupServiceIMP.getFriendGroup(user.getUserName(),groupname);
        if (null!=friendGroup){
            result.put("msg","通讯录中存在同名分组，修改失败！");
            return result;
        }
        FriendGroup friendGroup2=friendGroupServiceIMP.getFriendGroup(user.getUserName(),groupId);
        if (null!=friendGroup2&&friendGroup2.getDefaultGroup()==FriendGroupStatus.DEFAULT.getStatus()){
            result.put("msg","该分组为默认分组，不可以修改！");
            return result;
        }
        friendGroup=new FriendGroup();
        friendGroup.setId(groupId);
        friendGroup.setGroupName(groupname);
        friendGroupServiceIMP.updateFriendGrop(friendGroup);
        result.put("msg","分组修改成功！");
        return result;
    }
    @RequestMapping(value = "/user/addAddressBook")
    @ResponseBody
    public Map<String,Object> addAddressBook(@RequestParam("email")String email,
                                             @RequestParam("groupid")long groupid
            ,HttpSession session){
        Map<String,Object> result=new HashMap<>();
        LoginUser user = (LoginUser) session.getAttribute("user");
        StaffInfo staffInfoByEmail = staffInfoServiceIMP.getStaffInfoByEmail(email);
        if (null==staffInfoByEmail){
            result.put("msg","系统没有该邮箱地址的员工，无法添加！");
            return result;
        }
        String username = email.split("@")[0];
        List<FriendGroup> friendGroups = friendGroupServiceIMP.getFriendGroups(user.getUserName());
        List<Long> collect = friendGroups.stream().map(friendGroup -> friendGroup.getId()).collect(Collectors.toList());
        List<AddressBook> addressBooks=friendGroupServiceIMP.getAddressBooks(collect,username);
        if (null!=addressBooks&&addressBooks.size()>0){
            result.put("msg","联系人已经存在于你的通讯录！");
            return result;
        }
        AddressBook addressBook=new AddressBook();
        addressBook.setFriendgroupId(groupid);
        addressBook.setUserName(username);
        friendGroupServiceIMP.addAddressBook(addressBook);
        result.put("msg","好友添加成功");
        return result;
    }
    @RequestMapping(value = "/user/deleteAddressBook")
    @ResponseBody
    public Map<String,Object> deleteAddressBook(@RequestParam("groupid")long groupid,
            @RequestParam("username")String username,HttpSession session){
        Map<String,Object> result=new HashMap<>();
        LoginUser user = (LoginUser) session.getAttribute("user");
        friendGroupServiceIMP.deleteAddressBook(groupid,username);
        result.put("msg","联系人删除成功！");
        return result;
    }

}
