package com.example.email.mapper;

import com.example.email.entity.Massage;
import com.example.email.entity.MassageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Component;

@Component
public interface MassageMapper {
    long countByExample(MassageExample example);

    int deleteByExample(MassageExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Massage record);

    int insertSelective(Massage record);

    List<Massage> selectByExampleWithBLOBsWithRowbounds(MassageExample example, RowBounds rowBounds);

    List<Massage> selectByExampleWithBLOBs(MassageExample example);

    List<Massage> selectByExampleWithRowbounds(MassageExample example, RowBounds rowBounds);

    List<Massage> selectByExample(MassageExample example);

    Massage selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Massage record, @Param("example") MassageExample example);

    int updateByExampleWithBLOBs(@Param("record") Massage record, @Param("example") MassageExample example);

    int updateByExample(@Param("record") Massage record, @Param("example") MassageExample example);

    int updateByPrimaryKeySelective(Massage record);

    int updateByPrimaryKeyWithBLOBs(Massage record);

    int updateByPrimaryKey(Massage record);
}