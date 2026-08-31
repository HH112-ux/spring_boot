package com.jh.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeacherController {

    @GetMapping("/teacher")
    public String index(){
        return "hello spring boot 3";
    }
}
