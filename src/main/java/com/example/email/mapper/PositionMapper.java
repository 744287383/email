package com.example.email.mapper;

import com.example.email.entity.Position;
import com.example.email.entity.PositionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface PositionMapper {
    long countByExample(PositionExample example);

    int deleteByExample(PositionExample example);

    int deleteByPrimaryKey(Long positionId);

    int insert(Position record);

    int insertSelective(Position record);

    List<Position> selectByExampleWithRowbounds(PositionExample example, RowBounds rowBounds);

    List<Position> selectByExample(PositionExample example);

    Position selectByPrimaryKey(Long positionId);

    int updateByExampleSelective(@Param("record") Position record, @Param("example") PositionExample example);

    int updateByExample(@Param("record") Position record, @Param("example") PositionExample example);

    int updateByPrimaryKeySelective(Position record);

    int updateByPrimaryKey(Position record);
}