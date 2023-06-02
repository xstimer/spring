package com.example.springboot.controller;

import com.example.springboot.common.Result;
import com.example.springboot.controller.request.LoginRequest;
import com.example.springboot.entity.Admin;
import com.example.springboot.service.IAdminService;
import com.example.springboot.utils.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@CrossOrigin
@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    IAdminService adminService;

    @PostMapping("/login")
    public Result login(@RequestBody LoginRequest loginRequest){
        Admin admin = adminService.login(loginRequest);
        if(admin!=null){
            String token = TokenUtil.sign(admin);
            admin.setToken(token);
        }else{
            return Result.error("账号或密码错误");
        }
        return Result.success(admin,"登录成功");
    }

    @PostMapping("/logout")
    public Result logout(){
        return Result.success("登出成功");
    }

}
