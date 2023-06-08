package com.example.springboot.service.impl;

import com.example.springboot.entity.Classroom;
import com.example.springboot.entity.Examination;
import com.example.springboot.entity.Student;
import com.example.springboot.mapper.AutoMapper;
import com.example.springboot.service.IExamService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamService implements IExamService {
    @Autowired
    AutoMapper autoMapper;

    @Override
    public void individuallyArrange(Examination examination) {

    }

    @Override
    public String searchStartTime(String date) {
        return autoMapper.searchStartTime(date);
    }

    @Override
    public void RecordingDateTime(String date, String start) {
        autoMapper.recordingDateTime(date,start);
    }

    @Override
    public int getCourseid(String coursename) {
        return autoMapper.getCourseId(coursename);
    }

    @Override
    public List<Student> studentlist(int courseid) {
        return autoMapper.studentByCourseid(courseid);
    }

    @Override
    public String getTeacherName(long stuid, int courseid) {
        return autoMapper.getTeacherName(stuid,courseid);
    }

    @Override
    public String getMajorName(long stuid) {
        return autoMapper.getMajorName(stuid);
    }

    @Override
    public void insertExport(List<Examination> exam) {
        autoMapper.insertExport(exam);
    }

    @Override
    public void updateStuState(int courseid) {
        autoMapper.updateStuState(courseid);
    }

    @Override
    public List<Classroom> searchByRoomid(List<Integer> selection) {
        return autoMapper.searchByRoomid(selection);
    }

    @Override
    public List<Examination> getReadyArrangeInfo() {
        return autoMapper.getReadyArrangeInfo();
    }

    @Override
    public String getTestDate() {
        return autoMapper.getTestDate();
    }

    @Override
    public void deletExport() {
        autoMapper.deletExport();
    }

    @Override
    public String getTestStart() {
        return autoMapper.getTestStart();
    }

    @Override
    public void deletDateInfo() {
        autoMapper.deleteDateInfo();
    }

    @Override
    public Classroom getRoomById(int id) {
        return autoMapper.getRoomById(id);
    }

    @Override
    public List<Student> getStuByStuid(@Param("selections")List<Long> selections,@Param("courseid") int courseid) {
        return autoMapper.getStuByStuid(selections,courseid);
    }

    @Override
    public void insertIndividually(@Param("studentList") List<Student> studentList,@Param("admission") String admission,@Param("coursename")  String coursename,@Param("startTime")  String startTime,@Param("endTime")  String endTime,@Param("room")  String room) {
        autoMapper.insertIndividually(studentList,admission,coursename,startTime,endTime,room);
    }

    @Override
    public void updateStuIndividuallyState(List<Student> studentList) {
        autoMapper.updateStuIndividuallyState(studentList);
    }
}
