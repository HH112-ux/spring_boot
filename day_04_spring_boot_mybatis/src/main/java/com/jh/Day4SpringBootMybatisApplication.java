package com.jh;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//扫描mapper
@MapperScan(basePackages = {"com.jh.mapper"})
public class Day4SpringBootMybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(Day4SpringBootMybatisApplication.class, args);
    }
}
