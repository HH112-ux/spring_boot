package com.jh.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Value("${age}")
    private int age;

    @GetMapping("/uservalue")
    public Object show(){
        return age;
    }
}
