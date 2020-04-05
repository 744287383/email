package com.example.email.mapper;

import com.example.email.entity.FriendGroup;
import com.example.email.entity.FriendGroupExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Component;

@Component
public interface FriendGroupMapper {
    long countByExample(FriendGroupExample example);

    int deleteByExample(FriendGroupExample example);

    int deleteByPrimaryKey(Long id);

    int insert(FriendGroup record);

    int insertSelective(FriendGroup record);

    List<FriendGroup> selectByExampleWithRowbounds(FriendGroupExample example, RowBounds rowBounds);

    List<FriendGroup> selectByExample(FriendGroupExample example);

    FriendGroup selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") FriendGroup record, @Param("example") FriendGroupExample example);

    int updateByExample(@Param("record") FriendGroup record, @Param("example") FriendGroupExample example);

    int updateByPrimaryKeySelective(FriendGroup record);

    int updateByPrimaryKey(FriendGroup record);
}