package com.example.email.Service;

import com.example.email.entity.Users;
import com.example.email.mapper.UsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceIMP {
    @Autowired
   private  UsersMapper usersMapper;
    public void addUsers(Users users) {
        usersMapper.insertSelective(users);
    }
}
