package com.example.springboot.service;

import com.example.springboot.controller.request.StuPageRequest;
import com.example.springboot.entity.Course;
import com.example.springboot.entity.Student;

import java.util.List;

public interface IStuService {
    Object page(StuPageRequest stuPageRequest);

    void add(Student student);

    void update(Student student);

    void delete(int id);

    List<Course> getCourse();
}
