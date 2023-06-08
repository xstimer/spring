package com.example.springboot.controller.request;

import lombok.Data;

@Data
public class StuPageRequest extends BaseRequest{
    private long stuid;
    private int sort;
    private int courseid;

}
