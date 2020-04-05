package com.example.email.Service;

import com.example.email.ModelDTO.LoginUser;
import com.example.email.ModelDTO.PositionListDTO;
import com.example.email.entity.*;
import com.example.email.mapper.DeptMapper;
import com.example.email.mapper.PositionMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class PositionServiceImp {
@Autowired
private PositionMapper positionMapper;
@Autowired
private DeptInfoServiceIMP deptInfoServiceIMP;
@Autowired
private AuthorrityServiceImp authorrityServiceImp;
@Autowired
private DeptMapper deptMapper;
    public PageInfo<PositionListDTO> getAllPositionBypage(int indexPage, int size, LoginUser loginUser) {
        List<Dept> alLDepts = deptInfoServiceIMP.getAlLDept();
        Map<Long, Dept> collect1 = alLDepts.stream().collect(Collectors.toMap(dept -> dept.getDeptNo(), dept -> dept));
        List<Authorrity> authorrities=authorrityServiceImp.getAllAuth();
        Map<Long, Authorrity> collect2 = authorrities.stream().collect(Collectors.toMap(authorrity -> authorrity.getAuthId(), authorrity -> authorrity));
        PageHelper.startPage(indexPage,size);
        PositionExample positionExample=new PositionExample();
        positionExample.or().andPositionNameNotEqualTo("root");
        List<Position> positions = positionMapper.selectByExample(positionExample);
        PageInfo pageInfos=new PageInfo(positions,5 );
        List<PositionListDTO> collect = positions.stream().map(position -> {
            PositionListDTO positionListDTO = new PositionListDTO();
            BeanUtils.copyProperties(position, positionListDTO);
            String deptName = collect1.get(positionListDTO.getDeptNo()).getDeptName();
            positionListDTO.setDeptName(deptName);
            String authName = collect2.get(positionListDTO.getAuthId()).getAuthName();
            positionListDTO.setAuthName(authName);
            return positionListDTO;
        }).collect(Collectors.toList());
        pageInfos.setList(collect);
        return pageInfos;
    }
    public PageInfo<PositionListDTO> getAllPositionBypage(int indexPage, int size, LoginUser loginUser,long deptno) {
        DeptExample deptExample=new DeptExample();
        deptExample.or().andDeptNoEqualTo(deptno);
        List<Dept> depts = deptMapper.selectByExample(deptExample);
        Dept dept=depts.get(0);
        List<Authorrity> authorrities=authorrityServiceImp.getAllAuth();
        Map<Long, Authorrity> collect2 = authorrities.stream().collect(Collectors.toMap(authorrity -> authorrity.getAuthId(), authorrity -> authorrity));
        PageHelper.startPage(indexPage,size);
        PositionExample positionExample=new PositionExample();
        positionExample.or().andPositionNameNotEqualTo("root").andDeptNoEqualTo(deptno);
        positionExample.setOrderByClause("create_time desc");
        List<Position> positions = positionMapper.selectByExample(positionExample);
        PageInfo pageInfos=new PageInfo(positions,5 );
        List<PositionListDTO> collect = positions.stream().map(position -> {
            PositionListDTO positionListDTO = new PositionListDTO();
            BeanUtils.copyProperties(position, positionListDTO);
            String deptName = dept.getDeptName();
            positionListDTO.setDeptName(deptName);
            String authName = collect2.get(positionListDTO.getAuthId()).getAuthName();
            positionListDTO.setAuthName(authName);
            return positionListDTO;
        }).collect(Collectors.toList());
        pageInfos.setList(collect);
        return pageInfos;
    }
   public List<Position> getPositionALL(){
       List<Position> positions = positionMapper.selectByExample(new PositionExample());
       return positions;
   }

    public List<Position> getpositionByDeptNo(long deptNo) {
        PositionExample positionExample=new PositionExample();
        positionExample.or().andDeptNoEqualTo(deptNo);
        List<Position> positions = positionMapper.selectByExample(positionExample);



        return positions;
    }
    public List<Position> getpositionByDeptNo(long deptNo,long authId) {
        PositionExample positionExample=new PositionExample();
        positionExample.or().andDeptNoEqualTo(deptNo).andAuthIdBetween((long)2,(long)3);
        List<Position> positions = positionMapper.selectByExample(positionExample);



        return positions;
    }

    public void deletePositionByPositionId(long positionId) {
        PositionExample positionExample=new PositionExample();
        positionExample.or().andPositionIdEqualTo(positionId);
        positionMapper.deleteByExample(positionExample);
    }

    public void updatePositionByPositionId(Position position) {
        PositionExample positionExample=new PositionExample();
        positionExample.or().andPositionIdEqualTo(position.getPositionId());
        positionMapper.updateByExampleSelective(position,positionExample);

    }

    public void addPosition(Position position) {
        positionMapper.insertSelective(position);
    }

    public Position getPositionByPositionNameAndDeptName(String positionName, long deptNo) {
        PositionExample positionExample=new PositionExample();
        positionExample.or().andPositionNameEqualTo(positionName).andDeptNoEqualTo(deptNo);
        List<Position> positions = positionMapper.selectByExample(positionExample);
        if (null==positions||positions.size()==0){
            return null;
        }
        return positions.get(0);
    }
}
