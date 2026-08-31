package com.jh.controller;

import com.jh.model.Users;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UsersController {

    @Resource
    private Users user;

    @Resource
    private Environment env;

    @GetMapping
    public Object showYaml(){
        return user;
    }

    @GetMapping("/env")
    public Object inv(){
        System.out.println(env.getProperty("sysUser"));
        System.out.println(env.getProperty("age"));
        System.out.println(env.getProperty("money"));
        System.out.println(env.getProperty("birth"));
        System.out.println(env.getProperty("com.jh.model.users.name"));
        return "hello";
    }
}
