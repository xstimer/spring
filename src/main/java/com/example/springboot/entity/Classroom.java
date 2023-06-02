package com.example.springboot.entity;

import lombok.Data;

@Data
public class Classroom {
    private String roomid;
    private String name;
    private String capacity;
    private int campus;
    private int state = 0;
}
