package com.example.springboot.controller;

import com.example.springboot.common.Result;
import com.example.springboot.controller.request.LoginRequest;
import com.example.springboot.entity.Admin;
import com.example.springboot.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    IAdminService adminService;

//    @GetMapping("/admin")
//    public Result listAdmin(){
//        List<Admin>admin = adminService.listAdmin();
//        return Result.success(admin);
//    }

    @PostMapping("/login")
    public Result login(@RequestBody LoginRequest loginRequest){
        Admin admin = adminService.login(loginRequest);
        return Result.success(admin);
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable int id){
        Admin obj = adminService.getById(id);
        return Result.success(obj);
    }

}
