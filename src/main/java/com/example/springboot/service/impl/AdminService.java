package com.example.springboot.service.impl;

import com.example.springboot.controller.request.LoginRequest;
import com.example.springboot.entity.Admin;
import com.example.springboot.exception.ServiceException;
import com.example.springboot.mapper.AutoMapper;
import com.example.springboot.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService implements IAdminService {
    @Autowired
    AutoMapper mapper;

    @Override
    public Admin login(LoginRequest loginRequest) {
        Admin admin = mapper.getByUsernameAndPassword(loginRequest);
        return admin;
    }


}
