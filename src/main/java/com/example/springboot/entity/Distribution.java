package com.example.springboot.entity;

import lombok.Data;

import java.util.List;

@Data
public class Distribution {
    private String examDate;   //考试日期
    private String startTime;  //考试考试时间
    private String endTime;    //考试结束时间
    private String duration;   //考试时长
    private String interval;   //考试间隔
    private String coursename;     //考试科目
    private List<Integer> selections;    //备选考场
}
