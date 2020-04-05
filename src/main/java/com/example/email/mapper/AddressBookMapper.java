package com.example.email.mapper;

import com.example.email.entity.AddressBook;
import com.example.email.entity.AddressBookExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Component;

@Component
public interface AddressBookMapper {
    long countByExample(AddressBookExample example);

    int deleteByExample(AddressBookExample example);

    int deleteByPrimaryKey(Long aid);

    int insert(AddressBook record);

    int insertSelective(AddressBook record);

    List<AddressBook> selectByExampleWithRowbounds(AddressBookExample example, RowBounds rowBounds);

    List<AddressBook> selectByExample(AddressBookExample example);

    AddressBook selectByPrimaryKey(Long aid);

    int updateByExampleSelective(@Param("record") AddressBook record, @Param("example") AddressBookExample example);

    int updateByExample(@Param("record") AddressBook record, @Param("example") AddressBookExample example);

    int updateByPrimaryKeySelective(AddressBook record);

    int updateByPrimaryKey(AddressBook record);
}