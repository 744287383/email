package com.example.email.Service;

import com.example.email.ModelDTO.LoginUser;
import com.example.email.ModelDTO.StaffInfo;
import com.example.email.entity.*;
import com.example.email.mapper.AuthorrityMapper;
import com.example.email.mapper.PositionMapper;
import com.example.email.mapper.StaffMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginService {
    @Autowired
    private StaffMapper staffMapper;
    @Autowired
    private PositionMapper positionMapper;
    @Autowired
    private AuthorrityMapper authorrityMapper;
    @Autowired
    private StaffInfoServiceIMP staffInfoServiceIMP;
    public boolean isPasswordMatch(String email,String password){
        StaffExample staffExample=new StaffExample();
        staffExample.or().andEmailEqualTo(email);
        List<Staff> staffs = staffMapper.selectByExample(staffExample);
        if (null==staffs||0==staffs.size()){
            return false;
        }else {
            Staff staff=staffs.get(0);
            if (staff.getLoginPassword().equals(password)){
                return true;
            }
            return false;

        }
    }
    public LoginUser getLoginUserInfo(String email,String password){
        LoginUser loginUser=new LoginUser();
        StaffInfo staffInfo = staffInfoServiceIMP.getStaffInfoByEmail(email);
        BeanUtils.copyProperties(staffInfo,loginUser);
        loginUser.setAuthorrityName(staffInfo.getAuthorrity().getAuthName());
        loginUser.setPositionName(staffInfo.getPositions().getPositionName());
        return loginUser;
    }
    public void updateToken(String token,String email){
        Staff staff=new Staff();
        staff.setToken(token);
        StaffExample staffExample=new StaffExample();
        staffExample.or().andEmailEqualTo(email);
        staffMapper.updateByExampleSelective(staff, staffExample);

    }
}
