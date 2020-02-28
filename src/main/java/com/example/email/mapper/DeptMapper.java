package com.example.email.mapper;

import com.example.email.entity.Dept;
import com.example.email.entity.DeptExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Component;

@Component
public interface DeptMapper {
    long countByExample(DeptExample example);

    int deleteByExample(DeptExample example);

    int deleteByPrimaryKey(Long deptNo);

    int insert(Dept record);

    int insertSelective(Dept record);

    List<Dept> selectByExampleWithRowbounds(DeptExample example, RowBounds rowBounds);

    List<Dept> selectByExample(DeptExample example);

    Dept selectByPrimaryKey(Long deptNo);

    int updateByExampleSelective(@Param("record") Dept record, @Param("example") DeptExample example);

    int updateByExample(@Param("record") Dept record, @Param("example") DeptExample example);

    int updateByPrimaryKeySelective(Dept record);

    int updateByPrimaryKey(Dept record);
}