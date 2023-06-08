package com.example.springboot.controller;

import com.example.springboot.common.Result;
import com.example.springboot.controller.request.StuPageRequest;
import com.example.springboot.entity.Course;
import com.example.springboot.entity.Student;
import com.example.springboot.service.IStuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    IStuService stuService;

    @GetMapping("/page")            //分页查询
    public Result page(StuPageRequest stuPageRequest){
        return Result.success(stuService.page(stuPageRequest));
    }

    @GetMapping("/select")
    public Result getByCourse(StuPageRequest stuPageRequest){
        return Result.success(stuService.getByCourse(stuPageRequest));
    }
    @PostMapping("/upload")            //插入学生信息
    public Result save(@RequestBody List<Student> student){
            stuService.add(student);
        return Result.success("导入成功");
    }

    @PostMapping("/add")
    public Result add(@RequestBody Student student){
        stuService.addAlone(student);
        return Result.success();
    }

    @PutMapping ("/update")         //学生信息更新
    public Result update(@RequestBody Student student){
        stuService.update(student);
        stuService.deleteStudentExam(student);
        return Result.success();
    }

    @DeleteMapping("/delete/{id}")  //学生信息删除
    public Result delete(@PathVariable int id){
        stuService.delete(id);
        return Result.success();
    }

    @DeleteMapping("/deletAllStu")  //删除所有学生信息
    public Result deleteAll(){
        stuService.deleteAll();
        return Result.success();
    }

    @GetMapping("/course")          //课程信息
    public Result getCourse(){
        List<Course> list = stuService.getCourse();
        return Result.success(list);
    }

    @GetMapping("/Scheduled")       //已安排的学生
    public Result readyStudent(){
        return Result.success(stuService.readyStudent());
    }

    @GetMapping("/overview")        //总人数
    public Result totalNum(){
        List<Integer>total = new ArrayList<>();
        total.add(stuService.totalnum1());
        total.add(stuService.totalnum2());
        total.add(stuService.totalnum3());
        total.add(stuService.readyNum1());
        total.add(stuService.readyNum2());
        total.add(stuService.readyNum3());
        return Result.success(total);
    }

}
