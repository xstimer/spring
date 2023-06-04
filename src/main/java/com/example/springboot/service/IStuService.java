package com.example.springboot.service;

import com.example.springboot.controller.request.StuPageRequest;
import com.example.springboot.entity.Course;
import com.example.springboot.entity.Student;

import java.util.List;

public interface IStuService {
    Object page(StuPageRequest stuPageRequest);

    void add(List<Student> student);

    void update(Student student);

    void delete(int id);

    List<Course> getCourse();

    Student readyStudent();

    int totalNum();

    int readyNum();


    void deleteAll();

    int totalnum1();

    int readyNum1();

    int totalnum2();

    int readyNum2();

    int totalnum3();

    int readyNum3();

    void addAlone(Student student);
}
