package com.example.springboot.mapper;

import com.example.springboot.controller.request.RoomPageRequest;
import com.example.springboot.controller.request.StuPageRequest;
import com.example.springboot.entity.Admin;
import com.example.springboot.entity.Classroom;
import com.example.springboot.entity.Course;
import com.example.springboot.entity.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AutoMapper {
    List<Admin>listAdmin();

    /* 学生信息增删改查*/
    List<Student> studentSearch(StuPageRequest stuPageRequest);
    void studentAdd(Student student);
    void studentUpdate(Student student);
    void studentDelete(int id);
    /*  教室信息增删改查   */
    List<Classroom>roomSearch(RoomPageRequest roomPageRequest);
    void roomAdd(Classroom classroom);
    void roomUpdate(Classroom classroom);
    void deleteRoom(int id);
    List<Classroom> listRoom();

    List<Course> getCourse();
}
