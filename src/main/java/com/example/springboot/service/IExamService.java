package com.example.springboot.service;

import com.example.springboot.entity.Classroom;
import com.example.springboot.entity.Examination;
import com.example.springboot.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IExamService {

    void individuallyArrange(Examination examination);

    String searchStartTime(String date);

    void RecordingDateTime(String date, String start);

    int getCourseid(String coursename);

    List<Student> studentlist(int courseid);

    String getTeacherName(long stuid, int courseid);

    String getMajorName(long stuid);

    void insertExport(List<Examination> exam);

    void updateStuState(int courseid);

    List<Classroom> searchByRoomid(List<Integer> selection);

    List<Examination> getReadyArrangeInfo();

    String getTestDate();

    void deletExport();

    String getTestStart();

    void deletDateInfo();

    Classroom getRoomById(int id);

    List<Student> getStuByStuid(@Param("selections")List<Long> selections,@Param("courseid") int courseid);

    void insertIndividually(@Param("studentList") List<Student> studentList,@Param("admission") String admission,@Param("coursename")  String coursename,@Param("startTime")  String startTime,@Param("endTime")  String endTime,@Param("room")  String room);

    void updateStuIndividuallyState(List<Student> studentList);
}
