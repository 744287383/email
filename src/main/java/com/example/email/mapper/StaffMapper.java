package com.example.email.mapper;

import com.example.email.entity.Staff;
import com.example.email.entity.StaffExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Component;

@Component
public interface StaffMapper {
    long countByExample(StaffExample example);

    int deleteByExample(StaffExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Staff record);

    int insertSelective(Staff record);

    List<Staff> selectByExampleWithBLOBsWithRowbounds(StaffExample example, RowBounds rowBounds);

    List<Staff> selectByExampleWithBLOBs(StaffExample example);

    List<Staff> selectByExampleWithRowbounds(StaffExample example, RowBounds rowBounds);

    List<Staff> selectByExample(StaffExample example);

    Staff selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Staff record, @Param("example") StaffExample example);

    int updateByExampleWithBLOBs(@Param("record") Staff record, @Param("example") StaffExample example);

    int updateByExample(@Param("record") Staff record, @Param("example") StaffExample example);

    int updateByPrimaryKeySelective(Staff record);

    int updateByPrimaryKeyWithBLOBs(Staff record);

    int updateByPrimaryKey(Staff record);
}