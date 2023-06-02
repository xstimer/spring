package com.example.springboot.service.impl;

import com.example.springboot.common.Result;
import com.example.springboot.controller.request.LoginRequest;
import com.example.springboot.entity.Admin;
import com.example.springboot.exception.ServiceException;
import com.example.springboot.mapper.AutoMapper;
import com.example.springboot.service.IAdminService;
import com.example.springboot.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService implements IAdminService {
    @Autowired
    AutoMapper mapper;
//    @Override
//    public List<Admin> listAdmin() {
//        return mapper.listAdmin();
//    }

    @Override
    public Admin login(LoginRequest loginRequest) {
        Admin admin = mapper.getByUsernameAndPassword(loginRequest);
        if(admin==null){
            throw new ServiceException("用户名错误或密码错误");
        }
        String token = TokenUtils.genToken(String.valueOf((admin.getId())),admin.getPassword());
        admin.setToken(token);
        return admin;
    }

    @Override
    public Admin getById(int id) {

        return mapper.getById(id);
    }
}
