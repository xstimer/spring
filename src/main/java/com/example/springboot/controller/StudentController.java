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

    @GetMapping("/page") //分页查询
    public Result page(StuPageRequest stuPageRequest){
        return Result.success(stuService.page(stuPageRequest));
    }

    @PostMapping("/add")//插入学生信息
    public Result save(@RequestBody Student student){
        stuService.add(student);
        return Result.success();
    }

    @PostMapping("/update")
    public Result update(@RequestBody Student student){
        stuService.update(student);
        return Result.success();
    }

    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable int id){
        stuService.delete(id);
        return Result.success();
    }

    @GetMapping("/course")
    public Result getCourse(){
        List<Course> list = stuService.getCourse();
        return Result.success(list);
    }
}
