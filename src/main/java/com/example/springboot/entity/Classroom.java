package com.example.springboot.entity;

import lombok.Data;

@Data
public class Classroom {
    private int id;
    private String name;
    private int capacity;
    private int campus;
    private int state = 0;
}
