package com.example.springboot.service;

import com.example.springboot.controller.request.RoomPageRequest;
import com.example.springboot.entity.Classroom;

import java.util.List;

public interface IRoomService {

    Object page (RoomPageRequest roomPageRequest);

    void add(Classroom classroom);

    void update(Classroom classroom);

    void delete(int id);

    List<Classroom> listRoom();
}
