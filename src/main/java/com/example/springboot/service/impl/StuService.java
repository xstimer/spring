package com.example.springboot.service.impl;

import com.example.springboot.controller.request.StuPageRequest;
import com.example.springboot.entity.Course;
import com.example.springboot.entity.Student;
import com.example.springboot.mapper.AutoMapper;
import com.example.springboot.service.IStuService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StuService implements IStuService {
    @Autowired
    AutoMapper autoMapper;
    @Override
    public Object page(StuPageRequest stuPageRequest) {
        PageHelper.startPage(stuPageRequest.getPageNum(), stuPageRequest.getPageSize());
        List<Student> student = autoMapper.studentSearch(stuPageRequest);
        return new PageInfo<>(student);
    }

    @Override
    public void add(Student student){
        autoMapper.studentAdd(student);
    }

    @Override
    public void update(Student student) {
        autoMapper.studentUpdate(student);
    }

    @Override
    public void delete(int id) {
        autoMapper.studentDelete(id);
    }

    @Override
    public List<Course> getCourse() {
        return autoMapper.getCourse();
    }

    @Override
    public Student readyStudent() {
        return autoMapper.readyStu();
    }

    @Override
    public int totalNum() {
        return autoMapper.totalNum();
    }

    @Override
    public int readyNum() {
        return autoMapper.readyNum();
    }

    @Override
    public void deleteAll() {
        autoMapper.deleteAllStu();
    }

    @Override
    public int totalnum1() {
        return autoMapper.totalNum1();
    }
}
