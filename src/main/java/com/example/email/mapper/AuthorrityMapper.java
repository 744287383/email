package com.example.email.mapper;

import com.example.email.entity.Authorrity;
import com.example.email.entity.AuthorrityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface AuthorrityMapper {
    long countByExample(AuthorrityExample example);

    int deleteByExample(AuthorrityExample example);

    int deleteByPrimaryKey(Long authId);

    int insert(Authorrity record);

    int insertSelective(Authorrity record);

    List<Authorrity> selectByExampleWithRowbounds(AuthorrityExample example, RowBounds rowBounds);

    List<Authorrity> selectByExample(AuthorrityExample example);

    Authorrity selectByPrimaryKey(Long authId);

    int updateByExampleSelective(@Param("record") Authorrity record, @Param("example") AuthorrityExample example);

    int updateByExample(@Param("record") Authorrity record, @Param("example") AuthorrityExample example);

    int updateByPrimaryKeySelective(Authorrity record);

    int updateByPrimaryKey(Authorrity record);
}