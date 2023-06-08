package com.example.springboot.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Examination {
    private String teacher;
    private long stuid;
    private String name;
    private String admission;
    private String course;
    private String begin;
    private String end;
    private String room;
    private String major;
}
