package com.example.springboot.mapper;

import com.example.springboot.controller.request.LoginRequest;
import com.example.springboot.controller.request.RoomPageRequest;
import com.example.springboot.controller.request.StuPageRequest;
import com.example.springboot.entity.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AutoMapper {
    /* 用户登录 */
    Admin getByUsernameAndPassword(LoginRequest loginRequest);

    /* 学生信息增删改查*/
    List<Student> studentSearch(StuPageRequest stuPageRequest);
    void studentAdd(List<Student> student);
    void studentUpdate(Student student);
    void studentDelete(int id);
    Student readyStu();
    int totalNum();
    int readyNum();
    void deleteAllStu();

    /*  教室信息增删改查   */
    List<Classroom>roomSearch(RoomPageRequest roomPageRequest);
    void roomAdd(Classroom classroom);
    void roomUpdate(Classroom classroom);
    void deleteRoom(int id);
    List<Classroom> listRoom();


    /* 课程信息查询 */
    List<Course> getCourse();


    int totalNum1();

    int readyNum1();

    int totalNum2();

    int readyNum2();

    int totalNum3();

    int readyNum3();

    void addAlone(Student student);

    List<Student> getByCourse(StuPageRequest stuPageRequest);

    String searchStartTime(String date);

    void recordingDateTime(String date, String start);

    int getCourseId(String coursename);

    List<Student> studentByCourseid(int courseid);

    String getTeacherName(long stuid, int courseid);

    String getMajorName(long stuid);

    void insertExport(List<Examination> exam);

    void updateStuState(int courseid);

    List<Classroom> searchByRoomid(List<Integer> selection);

    List<Examination> getReadyArrangeInfo();

    String getTestDate();

    void deletExport();

    String getTestStart();

    void deleteDateInfo();

    Classroom getRoomById(int id);

    List<Student> getStuByStuid(@Param("selections")List<Long> selections,@Param("courseid") int courseid);

    void insertIndividually(@Param("studentList") List<Student> studentList,@Param("admission") String admission,@Param("coursename")  String coursename,@Param("startTime")  String startTime,@Param("endTime")  String endTime,@Param("room")  String room);

    void updateStuIndividuallyState(List<Student> studentList);

    void deleteStudentExam(Student student);
}
