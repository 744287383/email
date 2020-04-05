package com.example.email.Service;

import com.example.email.ModelDTO.LoginUser;
import com.example.email.ModelDTO.StaffInfo;
import com.example.email.ModelDTO.StaffListDTO;
import com.example.email.entity.*;
import com.example.email.mapper.AuthorrityMapper;
import com.example.email.mapper.DeptMapper;
import com.example.email.mapper.PositionMapper;
import com.example.email.mapper.StaffMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class StaffInfoServiceIMP {

    @Autowired
    private StaffMapper staffMapper;
    @Autowired
    private DeptMapper deptMapper;
    @Autowired
    private PositionMapper positionMapper;
    @Autowired
    private AuthorrityMapper authorrityMapper;
    @Autowired
    private DeptInfoServiceIMP deptInfoServiceIMP;
    @Autowired
    private PositionServiceImp positionServiceImp;
    @Autowired
    private AuthorrityServiceImp authorrityServiceImp;
    public StaffInfo getStaffInfoByToken(String token){
        StaffInfo staffInfo=new StaffInfo();
        StaffExample staffExample=new StaffExample();
        staffExample.or().andTokenEqualTo(token);
        List<Staff> staffs = staffMapper.selectByExample(staffExample);
        if (null==staffs||0==staffs.size()){
          return null;
        }
        Staff staff=staffs.get(0);
        BeanUtils.copyProperties(staff,staffInfo);
        Position position = getPositionById(staff.getPositionId());
        if (null==position){
            return staffInfo;
        }
        staffInfo.setPositions(position);
        Authorrity authorrity = getAuthorrityByAuthID(position.getAuthId());
        if (null==authorrity){
            return staffInfo;
        }
        staffInfo.setAuthorrity(authorrity);
        return staffInfo;
    }

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

    public void updatePassword(LoginUser user, String password1) {
        StaffExample staffExample=new StaffExample();
        staffExample.or().andEmailEqualTo(user.getEmail());
        Staff staff=new Staff();
        staff.setLoginPassword(password1);
        staffMapper.updateByExampleSelective(staff,staffExample);
    }

    public PageInfo<StaffListDTO> getStaffListDTO(int indexPage, int size, LoginUser loginUser) {
        List<Dept> alLDepts = deptInfoServiceIMP.getAlLDept();
        Map<Long, Dept> collect1 = alLDepts.stream().collect(Collectors.toMap(dept -> dept.getDeptNo(), dept -> dept));
        List<Position> positions=positionServiceImp.getPositionALL();
        Map<Long, Position> collect2 = positions.stream().collect(Collectors.toMap(position -> position.getPositionId(), position -> position));
        List<Authorrity> allAuth = authorrityServiceImp.getAllAuth();
        Map<Long, Authorrity> collect3 = allAuth.stream().collect(Collectors.toMap(authorrity -> authorrity.getAuthId(), authorrity -> authorrity));
        PageHelper.startPage(indexPage,size);
        StaffExample staffExample=new StaffExample();
        staffExample.or().andUserNameNotEqualTo("root");
        staffExample.setOrderByClause("start_time desc");
        List<Staff> staffs = staffMapper.selectByExample(staffExample);
        PageInfo pageInfos=new PageInfo(staffs,5);
        List<StaffListDTO> collect = staffs.stream().map(staff -> {
            StaffListDTO staffListDTO = new StaffListDTO();
            BeanUtils.copyProperties(staff, staffListDTO);

            String deptName = collect1.get(staffListDTO.getDeptNo()).getDeptName();
            staffListDTO.setDeptName(deptName);
            String positionName = collect2.get(staffListDTO.getPositionId()).getPositionName();
            staffListDTO.setPositionName(positionName);
            Position position = collect2.get(staffListDTO.getPositionId());
            Authorrity authorrity=collect3.get(position.getAuthId());
            staffListDTO.setAuthId(authorrity.getAuthId());
            staffListDTO.setAuthName(authorrity.getAuthName());

            return staffListDTO;
        }).collect(Collectors.toList());
        pageInfos.setList(collect);
        return pageInfos;
    }
    public PageInfo<StaffListDTO> getStaffListDTO(int indexPage, int size, LoginUser loginUser,long deptNo) {
        DeptExample deptExample=new DeptExample();
        deptExample.or().andDeptNoEqualTo(deptNo);
        List<Dept> depts = deptMapper.selectByExample(deptExample);
        Dept dept=depts.get(0);
        List<Position> positions=positionServiceImp.getPositionALL();
        Map<Long, Position> collect2 = positions.stream().collect(Collectors.toMap(position -> position.getPositionId(), position -> position));
        List<Authorrity> allAuth = authorrityServiceImp.getAllAuth();
        Map<Long, Authorrity> collect3 = allAuth.stream().collect(Collectors.toMap(authorrity -> authorrity.getAuthId(), authorrity -> authorrity));
        PageHelper.startPage(indexPage,size);
        StaffExample staffExample=new StaffExample();
        staffExample.or().andUserNameNotEqualTo("root").andUserNameNotEqualTo(loginUser.getUserName()).andDeptNoEqualTo(deptNo);
        staffExample.setOrderByClause("start_time desc");
        List<Staff> staffs = staffMapper.selectByExample(staffExample);
        PageInfo pageInfos=new PageInfo(staffs,5);
        List<StaffListDTO> collect = staffs.stream().map(staff -> {
            StaffListDTO staffListDTO = new StaffListDTO();
            BeanUtils.copyProperties(staff, staffListDTO);
            String deptName = dept.getDeptName();
            staffListDTO.setDeptName(deptName);
            String positionName = collect2.get(staffListDTO.getPositionId()).getPositionName();
            staffListDTO.setPositionName(positionName);
            Position position = collect2.get(staffListDTO.getPositionId());
            Authorrity authorrity=collect3.get(position.getAuthId());
            staffListDTO.setAuthId(authorrity.getAuthId());
            staffListDTO.setAuthName(authorrity.getAuthName());
            return staffListDTO;
        }).collect(Collectors.toList());
        pageInfos.setList(collect);
        return pageInfos;
    }


    public List<Staff> getStaffListByDeptNo(long deptNo) {
        StaffExample staffExample=new StaffExample();
        staffExample.or().andDeptNoEqualTo(deptNo);
        List<Staff> staff = staffMapper.selectByExample(staffExample);
        return staff;
    }

    public List<Staff> getStaffByPostionId(long positionId) {
        StaffExample staffExample=new StaffExample();
        staffExample.or().andPositionIdEqualTo(positionId);
        List<Staff> staffs = staffMapper.selectByExample(staffExample);
        return staffs;
    }

    public void updateStaffByUserName(Staff staff) {
        StaffExample staffExample=new StaffExample();
        staffExample.or().andUserNameEqualTo(staff.getUserName());
        staffMapper.updateByExampleSelective(staff,staffExample);
    }

    public void addStaff(Staff staff) {
        staffMapper.insertSelective(staff);
    }

    public Staff getStaffByUsername(String username) {
        StaffExample staffExample=new StaffExample();
        staffExample.or().andUserNameEqualTo(username);
        List<Staff> staff = staffMapper.selectByExample(staffExample);
        if (null==staff||staff.size()==0){
            return null;
        }
        return staff.get(0);
    }

    public List<Staff> getStaffByDeptNo(String  username,Long deptNo) {
        StaffExample staffExample=new StaffExample();
        staffExample.or().andDeptNoEqualTo(deptNo).andUserNameNotEqualTo(username);
        List<Staff> staff = staffMapper.selectByExample(staffExample);
        return staff;
    }

    public List<Staff> getStaffAll(String username) {
        StaffExample staffExample = new StaffExample();
        staffExample.or().andUserNameNotEqualTo(username);
        List<Staff> staff = staffMapper.selectByExample(staffExample);

        return staff;
    }
}
