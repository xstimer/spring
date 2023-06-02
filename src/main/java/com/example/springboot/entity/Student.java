package com.example.springboot.entity;

import lombok.Data;

@Data
public class Student {
    private int id;
    private long stuid;
    private String sname;
    private String major;
    private String teacher;
    private int courseid;
    private String subcategory;
    private int campus;
    private int state = 0;
}
