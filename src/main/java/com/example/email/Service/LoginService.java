package com.example.email.Service;

import com.example.email.ModelDTO.LoginUser;
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
        StaffExample staffExample=new StaffExample();
        staffExample.or().andEmailEqualTo(email);
        List<Staff> staffs = staffMapper.selectByExample(staffExample);

            Staff staff=staffs.get(0);
            BeanUtils.copyProperties(staff,loginUser);
            PositionExample positionExample=new PositionExample();
            positionExample.or().andAuthIdEqualTo(staff.getId());
            List<Position> positions = positionMapper.selectByExample(positionExample);

            Position position=positions.get(0);
            AuthorrityExample authorrityExample=new AuthorrityExample();
            authorrityExample.or().andAuthIdEqualTo(position.getAuthId());
            List<Authorrity> authorrities = authorrityMapper.selectByExample(authorrityExample);
            Authorrity authorrity = authorrities.get(0);
            loginUser.setAuthorrity(authorrity.getAuthName());

            return loginUser;

    }
}
