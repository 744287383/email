package com.example.email.Service;

import com.example.email.ModelDTO.DeptInfo;
import com.example.email.ModelDTO.StaffInfo;
import com.example.email.entity.*;
import com.example.email.mapper.AuthorrityMapper;
import com.example.email.mapper.DeptMapper;
import com.example.email.mapper.PositionMapper;
import com.example.email.mapper.StaffMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DeptInfoServiceIMP {
    @Autowired
    private StaffInfoServiceIMP staffInfoServiceIMP;
    @Autowired
    private DeptMapper deptMapper;
    @Autowired
    private StaffMapper staffMapper;
    @Autowired
    private PositionMapper positionMapper;
    @Autowired
    private AuthorrityMapper authorrityMapper;
    public List<DeptInfo> getDeptInfoAll(){
        List<DeptInfo> deptInfos=new ArrayList<>();
        List<Dept> depts = deptMapper.selectByExample(new DeptExample());
        if (null==depts||0==depts.size()){
            return null;
        }
        List<DeptInfo> collect = depts.stream().map(dept -> {
            DeptInfo deptInfo = new DeptInfo();
            BeanUtils.copyProperties(dept, deptInfo);
            List<StaffInfo> staffInfoAllByDeptNo = getStaffInfoAllByDeptNo(dept.getDeptNo());
            deptInfo.setStaffInfos(staffInfoAllByDeptNo);
            return deptInfo;
        }).collect(Collectors.toList());
    return collect;
    }

    public List<StaffInfo> getStaffInfoAllByDeptNo(long deptNo){
        List<StaffInfo> staffInfos=new ArrayList<>();
        StaffExample staffExample=new StaffExample();
        staffExample.or().andDeptNoEqualTo(deptNo);
        List<Staff> staffs = staffMapper.selectByExample(staffExample);
        if (null==staffs||0==staffs.size()){
            return null;
        }
        List<StaffInfo> staffInfos1 = staffs.stream().map(staff -> {
            StaffInfo staffInfo = new StaffInfo();
            BeanUtils.copyProperties(staff, staffInfo);
            Position position = getPositionById(staff.getPositionId());

            if (null != position) {
                Authorrity authorrity = getAuthorrityByAuthID(position.getAuthId());
                staffInfo.setAuthorrity(authorrity);
                staffInfo.setPositions(position);
            }

            return staffInfo;
        }).collect(Collectors.toList());
       return staffInfos1;
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
}
