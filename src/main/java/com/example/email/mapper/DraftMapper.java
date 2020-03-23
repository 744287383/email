package com.example.email.mapper;

import com.example.email.entity.Draft;
import com.example.email.entity.DraftExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Component;

@Component
public interface DraftMapper {
    long countByExample(DraftExample example);

    int deleteByExample(DraftExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Draft record);

    int insertSelective(Draft record);

    List<Draft> selectByExampleWithRowbounds(DraftExample example, RowBounds rowBounds);

    List<Draft> selectByExample(DraftExample example);

    Draft selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Draft record, @Param("example") DraftExample example);

    int updateByExample(@Param("record") Draft record, @Param("example") DraftExample example);

    int updateByPrimaryKeySelective(Draft record);

    int updateByPrimaryKey(Draft record);
}