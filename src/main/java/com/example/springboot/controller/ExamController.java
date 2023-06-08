package com.example.springboot.controller;

import com.example.springboot.common.Result;
import com.example.springboot.entity.*;
import com.example.springboot.service.IExamService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.time.LocalDateTime;

@CrossOrigin
@RestController
@RequestMapping("/exam")
public class ExamController {
    @Autowired
    IExamService examService;

    //判断剩下时间是否能安排下一场考试
    public boolean isTimeValue(String start,String end,String dur)throws ParseException {
        //将String类型时间转换为Date比较

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime  start_time = LocalDateTime.parse(start, formatter);
        LocalDateTime  end_time = LocalDateTime.parse(end, formatter);
        int duration = Integer.parseInt(dur);

        // 加上考试实际时长
        LocalDateTime start_duration = start_time.plusMinutes(duration);

        // 比较结束时间和加上时长后的开始时间，判断考试时间段是否合法
        if (end_time.compareTo(start_duration) < 0) {
            return false;
        } else {
            return true;
        }
    }

    //累加时间
    public String calEndTime(String start,String dur) throws ParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime  start_time = LocalDateTime.parse(start, formatter);
        int duration = Integer.parseInt(dur);
        // 加上考试实际时长
        LocalDateTime endDateTime = start_time.plusMinutes(duration);
        String endTime = endDateTime.format(formatter);
        return endTime;
    }

    public String searchStartTime(String date){return examService.searchStartTime(date);}

    //用于生成准考证号
    public String genrateTestID(){
        Random random = new Random();

        long value = random.nextLong(); // 生成一个长整型随机数

        return String.valueOf(Math.abs(value)).substring(0, 15); // 转换为字符串并截取前 15 位
    }

    public void RecordingDateTime(String date,String start){
        examService.RecordingDateTime(date,start);
    }

    public int getCourseid(String coursename){
        return examService.getCourseid(coursename);
    }
    public List<Student> SearchStudentslist(int courseid){
        return examService.studentlist(courseid);
    }

    public String getTeacherName(long stuid,int courseid){
        return examService.getTeacherName(stuid,courseid);
    }

    public String getMajorName(long stuid){return examService.getMajorName(stuid);}

    public String conversion(int campus){
        if(campus == 1)
            return "花津校区";
        else if(campus == 2)
            return "赭山校区";
        else
            return "天门山校区";
    }

    public void Arrange(List<Examination> examinationList, int stuNum, List<Classroom> classroomList, List<Student> studentList,String courseName,String startTime,String endTime) throws ParseException {

        int count = 0;
        for (int i=0,j=0;i<stuNum;i++) {
            String room= conversion(classroomList.get(j).getCampus()) + classroomList.get(j).getName();
            String teacher = getTeacherName(studentList.get(i).getStuid(),studentList.get(i).getCourseid());
            String major = getMajorName(studentList.get(i).getStuid());
            Examination examination = new Examination();
            examination.setTeacher(teacher);
            examination.setStuid(studentList.get(i).getStuid());
            examination.setName(studentList.get(i).getSname());
            examination.setAdmission(genrateTestID());
            examination.setCourse(courseName);
            examination.setBegin(startTime);
            examination.setEnd(endTime);
            examination.setRoom(room);
            examination.setMajor(major);
            count++;
            if(count==classroomList.get(j).getCapacity()){
                j++;
                count=0;
            }
            examinationList.add(examination);
        }

    }

    public List<Classroom> searchByRoomid(List<Integer> selection){
        return examService.searchByRoomid(selection);
    }
    @PostMapping("/totalArrange")
    public Result distribution(@RequestBody Distribution distribution) throws ParseException{
        //判断时间是否合法
        if(!isTimeValue(distribution.getStartTime(),distribution.getEndTime(),distribution.getDuration()))
            return Result.error("考试起始与结束间隔不足一场考试时长");


        List<Classroom> huajin_room=new ArrayList<>();
        List<Classroom> zheshan_room=new ArrayList<Classroom>();
        List<Classroom> tianmen_room=new ArrayList<Classroom>();
        int total_hua_room=0,total_zhe_room=0,total_tian_room=0;

        List<Classroom>list = searchByRoomid(distribution.getSelections());
        //添加各校区考场和容纳数量
        for(int i = 0;i < list.size();i++)
            switch (list.get(i).getCampus()){
                case 1:
                    huajin_room.add(list.get(i));
                    total_hua_room += list.get(i).getCapacity();
                    break;
                case 2:
                    zheshan_room.add(list.get(i));
                    total_zhe_room += list.get(i).getCapacity();
                    break;
                case 3:
                    tianmen_room.add(list.get(i));
                    total_tian_room += list.get(i).getCapacity();
                    break;
                default:
                    return Result.error("目前只有花津校区、天门山校区、赭山校区！");
            }

        //查找参加当前课程下的学生
        int courseid=getCourseid(distribution.getCoursename());
        List<Student> studentList = SearchStudentslist(courseid);

        //判断是否有考生
        if(studentList.size()==0)
            return Result.error("该课程所有考生已分配完成！");


        List<Student> huajin_stu=new ArrayList<>();
        List<Student> zheshan_stu=new ArrayList<>();
        List<Student> tianmen_stu=new ArrayList<>();
        int total_hua_stu=0,total_zhe_stu=0,total_tian_stu=0;

        //添加各校区学生数
        for(int i=0;i<studentList.size();i++)
            switch (studentList.get(i).getCampus()) {
                case 1:
                    huajin_stu.add(studentList.get(i));
                    total_hua_stu++;
                    break;
                case 2:
                    zheshan_stu.add(studentList.get(i));
                    total_zhe_stu++;
                    break;
                case 3:
                    tianmen_stu.add(studentList.get(i));
                    total_tian_stu++;
                    break;
                default:
                    return Result.error("目前仅支持花津，赭山，天门山校区");
            }

        //比较考场容纳和考生数，判断是否能够容纳
        if(total_zhe_room<total_zhe_stu)
            return Result.error("所选赭山校区考试容纳不足");
        if(total_hua_room<total_hua_stu)
            return Result.error("所选花津校区考试容纳不足");
        if (total_tian_room<total_tian_stu)
            return Result.error("所选天门山校区考试容纳不足");

        //获取该天开始安排的时间
        String start_time=searchStartTime(distribution.getExamDate());
        String date=distribution.getExamDate();
        if(start_time==null||start_time.compareTo(distribution.getStartTime())<0)
            start_time=distribution.getStartTime();

        //分配后列表
        List<Examination> exam=new ArrayList<>();
        String courseName=distribution.getCoursename();
        String endTime=calEndTime(start_time,distribution.getDuration());

        //花津校区安排
        Arrange(exam,total_hua_stu,huajin_room,huajin_stu,courseName,start_time,endTime);

        //赭山校区安排
        Arrange(exam,total_zhe_stu,zheshan_room,zheshan_stu,courseName,start_time,endTime);

        //天门山校区安排
        Arrange(exam,total_tian_stu,tianmen_room,tianmen_stu,courseName,start_time,endTime);

        //统一插入学生安排后的信息
        insertExport(exam);

        //更新插入之后的学生状态
        updateStuState(courseid);

        //清空之前的日期信息
        deletDateInfo();

        //修改date日期下一场考试开始时间
        RecordingDateTime(date,calEndTime(endTime,distribution.getInterval()));

        return Result.success("安排成功！");
    }

    public void deletDateInfo() {
        examService.deletDateInfo();
    }

    public List<Examination> getReadyArrangeInfo() {
        return examService.getReadyArrangeInfo();
    }

    @DeleteMapping("/deletExport")
    public Result deletExport(){
        examService.deletExport();
        return Result.success();
    }

    @GetMapping("/getExamInfo")
    public Result getExamInfo(){
        return Result.success(getReadyArrangeInfo());
    }

    public void updateStuState(int courseid) {
        examService.updateStuState(courseid);
    }

    public void insertExport(List<Examination> exam) {
        examService.insertExport(exam);
    }



    @PostMapping("/individually")
    public Result IndividuallyArrange(@RequestBody Individually individually) throws ParseException {
        String teststart = getTestStart();
        if (teststart != null) {
            String now =teststart ;
            String input = individually.getExamDate() + " " + individually.getStartTime();
            if(isGreaterThanNow(now,input))
                return Result.error("日期不正确，请重试！");
        }

        boolean state[] = new boolean[4];
        int cnt = 0;

        int courseid=getCourseid(individually.getCoursename());
        List<Student> studentList = getStuByStuid(individually.getSelections(),courseid);


        for(int i=0;i < studentList.size(); i++) {
            int campus = studentList.get(i).getCampus();
            if (!state[campus]) {
                state[campus] = true;
                cnt ++ ;
            }
        }

        if (cnt > 1) return Result.error("请选择同一校区的学生");

        if (!state[getRoomById(individually.getId()).getCampus()])
            return Result.error("考生校区与机房校区不一致");


        if(individually.getSelections().size()>getRoomById(individually.getId()).getCapacity())
            return Result.error("所选教室容量不足以安排当前数量学生，请更换教室或者减少所选择的学生数量！");

        String startTime = individually.getExamDate() + " " + individually.getStartTime();

        String endTime=calEndTime(startTime,individually.getDuration());
        String admission = genrateTestID();
        String coursename = individually.getCoursename();
        String room =  conversion(getRoomById(individually.getId()).getCampus())+getRoomById(individually.getId()).getName();

        insertIndividually(studentList,admission,coursename,startTime,endTime,room);

        //更新插入之后的学生状态
        updateStuIndividuallyState(studentList);

        return Result.success("安排成功");
    }

    public void updateStuIndividuallyState(List<Student> studentList) {
        examService.updateStuIndividuallyState(studentList);
    }

    public void insertIndividually(@Param("studentList") List<Student> studentList,@Param("admission") String admission,@Param("coursename")  String coursename,@Param("startTime")  String startTime,@Param("endTime")  String endTime,@Param("room")  String room) {
        examService.insertIndividually(studentList,admission,coursename,startTime,endTime,room);
    }

    public List<Student> getStuByStuid(List<Long> selections, int courseid) {
        return examService.getStuByStuid(selections,courseid);
    }

    public Classroom getRoomById(int id){
        return examService.getRoomById(id);
    }

    public boolean isGreaterThanNow(String now,String input) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date1 = sdf.parse(now);
        Date date2 = sdf.parse(input);
        System.out.println(date1.getTime());
        System.out.println(date2.getTime());

        return date1.getTime()> date2.getTime();
    }
    public String getTestDate() {
        return examService.getTestDate();
    }

    public String getTestStart() {
        return examService.getTestStart();
    }
}
