package com.jh.controller;

import com.jh.model.Teacher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("teacher")
public class TeacherController {
    @Resource
    private Teacher teacher;

    @GetMapping
    public Object test(){
        return teacher;
    }
}
