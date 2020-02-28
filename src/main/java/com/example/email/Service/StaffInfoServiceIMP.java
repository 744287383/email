package com.example.email.Service;

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
public class StaffInfoServiceIMP {

    @Autowired
    private StaffMapper staffMapper;
    @Autowired
    private PositionMapper positionMapper;
    @Autowired
    private AuthorrityMapper authorrityMapper;

    public StaffInfo getStaffInfoByEmail(String email) {
        StaffInfo staffInfo = new StaffInfo();
        Staff staff = getStaffByEmail(email);
        if (null==staff){
            return null;
        }
        BeanUtils.copyProperties(staff,staffInfo);
        Position position = getPositionById(staff.getPositionId());
        if (null==position){
            return staffInfo;
        }
        staffInfo.setPositions(position);
        Authorrity authorrity = getAuthorrityByAuthID(position.getAuthId());
        if(null==authorrity){
            return staffInfo;
        }
        staffInfo.setAuthorrity(authorrity);
        return  staffInfo;


    }

    public StaffInfo getStaffInfoByUsername(String Username) {
        StaffInfo staffInfo = new StaffInfo();
        Staff staff = getStaffByUserName(Username);
        if (null==staff){
            return null;
        }
        BeanUtils.copyProperties(staff,staffInfo);
        Position position = getPositionById(staff.getPositionId());
        if (null==position){
            return staffInfo;
        }
        staffInfo.setPositions(position);
        Authorrity authorrity = getAuthorrityByAuthID(position.getAuthId());
        if(null==authorrity){
            return staffInfo;
        }
        staffInfo.setAuthorrity(authorrity);
        return  staffInfo;

    }

    private Authorrity getAuthorrityByAuthID(long AuthID) {
        AuthorrityExample authorrityExample = new AuthorrityExample();
        authorrityExample.or().andAuthIdEqualTo(AuthID);
        List<Authorrity> authorrities = authorrityMapper.selectByExample(authorrityExample);
        if (null == authorrities || 0 == authorrities.size()) {
            return null;
        } else {
            Authorrity authorrity = authorrities.get(0);
            return authorrity;
        }
    }

    private Position getPositionById(long id) {
        PositionExample positionExample = new PositionExample();
        positionExample.or().andPositionIdEqualTo(id);
        List<Position> positions = positionMapper.selectByExample(positionExample);
        if (null == positions || 0 == positions.size()) {
            return null;
        } else {
            Position position = positions.get(0);
            return position;

        }
    }

    private Staff getStaffByUserName(String username) {
        StaffExample staffExample = new StaffExample();
        staffExample.or().andUserNameEqualTo(username);
        List<Staff> staffs = staffMapper.selectByExample(staffExample);
        if (null == staffs || 0 == staffs.size()) {
            return null;
        } else {
            Staff staff = staffs.get(0);
            return staff;

        }
    }

    private Staff getStaffByEmail(String email) {
        StaffExample staffExample = new StaffExample();
        staffExample.or().andEmailEqualTo(email);
        List<Staff> staffs = staffMapper.selectByExample(staffExample);
        if (null == staffs || 0 == staffs.size()) {
            return null;
        } else {
            Staff staff = staffs.get(0);
            return staff;

        }
    }
}
