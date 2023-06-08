package com.example.springboot.controller;

import com.example.springboot.common.Result;
import com.example.springboot.controller.request.RoomPageRequest;
import com.example.springboot.entity.Classroom;
import com.example.springboot.service.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/classroom")
public class RoomController {
    @Autowired
    IRoomService roomService;

    @GetMapping("/page")  //分页查询
    public Result pagination(RoomPageRequest roomPageRequest){
        return Result.success(roomService.page(roomPageRequest));
    }

    @GetMapping("/search")
    public Result listRoom(){       //直接返回教室信息
        List<Classroom> room = roomService.listRoom();
        return Result.success(room);
    }

    @PostMapping("/add")        //插入教室信息
    public Result save(@RequestBody Classroom classroom){
        roomService.add(classroom);
        return Result.success();
    }

    @PutMapping("/update")     //更新教室信息
    public Result update(@RequestBody Classroom classroom){
        roomService.update(classroom);
        return Result.success();
    }

    @DeleteMapping("/delete/{id}")  //删除教室信息
    public Result delete(@PathVariable int id){
        roomService.delete(id);
        return Result.success();
    }

}
