package com.example.springboot.controller;

import com.example.springboot.common.Result;
import com.example.springboot.entity.Admin;
import com.example.springboot.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("/login")
public class AdminController {
    @Autowired
    IAdminService adminService;

    @GetMapping("/admin")
    public Result listAdmin(){
        List<Admin>admin = adminService.listAdmin();
        return Result.success(admin);
    }
}
