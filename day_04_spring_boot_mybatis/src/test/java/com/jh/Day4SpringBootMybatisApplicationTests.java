package com.jh;

import com.jh.entity.Student;
import com.jh.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class Day4SpringBootMybatisApplicationTests {
    @Resource
    private StudentService service;

    @Test
    void contextLoads() {
        List<Student> list = service.selectList();
        list.forEach(System.out::println);
    }
}
