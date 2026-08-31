package com.jh.test;

import com.jh.Day4SpringBootJunitApplication;
import com.jh.entity.Users;
import com.jh.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest(classes = Day4SpringBootJunitApplication.class)
class Day4SpringBootJunitApplicationTests {

    @Resource
    private UserService service;

    @Test
    void contextLoads() {
        List<Users> list = service.list();
        list.forEach(System.out::println);
    }
}
