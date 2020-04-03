package com.example.email.Service;

import com.example.email.entity.Authorrity;
import com.example.email.entity.AuthorrityExample;
import com.example.email.mapper.AuthorrityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorrityServiceImp {
    @Autowired
    private AuthorrityMapper authorrityMapper;
    public List<Authorrity> getAllAuth() {
        List<Authorrity> authorrities = authorrityMapper.selectByExample(new AuthorrityExample());
        return authorrities;
    }
}
