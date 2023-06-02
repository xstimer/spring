package com.example.springboot.entity;

import lombok.Data;

@Data
public class Admin {
    private String id;
    private String username;
    private String password;
    private String name;
    private String token;
}
