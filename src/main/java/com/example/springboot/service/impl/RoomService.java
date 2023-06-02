package com.example.springboot.service.impl;

import com.example.springboot.controller.request.RoomPageRequest;
import com.example.springboot.entity.Classroom;
import com.example.springboot.mapper.AutoMapper;
import com.example.springboot.service.IRoomService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService implements IRoomService {

    @Autowired
    AutoMapper autoMapper;
    @Override
    public Object page(RoomPageRequest roomPageRequest) {
        PageHelper.startPage(roomPageRequest.getPageNum(), roomPageRequest.getPageSize());
        List<Classroom> room = autoMapper.roomSearch(roomPageRequest);
        return new PageInfo<>(room);
    }
    @Override
    public void add(Classroom classroom){
        autoMapper.roomAdd(classroom);
    }

    @Override
    public void update(Classroom classroom) {
        autoMapper.roomUpdate(classroom);
    }

    @Override
    public void delete(int id) {
        autoMapper.deleteRoom(id);
    }

    @Override
    public List<Classroom> listRoom() {
        return autoMapper.listRoom();
    }



}
