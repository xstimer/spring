package com.example.springboot.service;

import com.example.springboot.controller.request.LoginRequest;
import com.example.springboot.entity.Admin;

import java.util.List;

public interface IAdminService {
    Admin login(LoginRequest loginRequest);


}
