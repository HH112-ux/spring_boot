package com.jh.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @GetMapping("list")
    public String list(){
        return "hello spring boot 2";
    }
}
