package com.example.springboot.entity;

import lombok.Data;

import java.util.List;

@Data
public class Individually {
    private String examDate;   //考试日期
    private String startTime;  //考试考试时间
    private String duration;   //考试时长
    private String coursename;     //考试科目
    private int id;    //教室
    private List<Long>selections;//前端返回的学号
}
