package com.example.springboot.controller.request;

import lombok.Data;

@Data
public class RoomPageRequest extends BaseRequest{
    private String name;
    private int sort;
}
