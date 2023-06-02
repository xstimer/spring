package com.example.springboot.controller;

import com.example.springboot.common.Result;
import com.example.springboot.controller.request.StuPageRequest;
import com.example.springboot.entity.Course;
import com.example.springboot.entity.Student;
import com.example.springboot.service.IStuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/add")            //插入学生信息
    public Result save(@RequestBody Student[] student){
        for(Student s:student)
            stuService.add(s);
        return Result.success("导入成功");
    }

    @PutMapping ("/update")         //学生信息更新
    public Result update(@RequestBody Student student){
        stuService.update(student);
        return Result.success("更新成功");
    }

    @DeleteMapping("/delete/{id}")  //学生信息删除
    public Result delete(@PathVariable int id){
        stuService.delete(id);
        return Result.success("删除成功");
    }

    @DeleteMapping("/deletAllStu")  //删除所有学生信息
    public Result deleteAll(){
        stuService.deleteAll();
        return Result.success("已全部删除");
    }

    @GetMapping("/course")          //课程信息
    public Result getCourse(){
        List<Course> list = stuService.getCourse();
        return Result.success(list);
    }

    @GetMapping("/Scheduled")       //已安排的学生信息
    public Result readyStudent(){
        return Result.success(stuService.readyStudent());
    }

    @GetMapping("/totalNum")        //总人数
    public Result totalNum(){
        return Result.success(stuService.totalNum());
    }

    @GetMapping("/readyNum")        //已安排的学生人数
    public Result readyNum(){
        return Result.success(stuService.readyNum());
    }

    @GetMapping("/totalNum1")       //花津总人数
    public Result totalNum1(){return  Result.success(stuService.totalnum1());}


}
