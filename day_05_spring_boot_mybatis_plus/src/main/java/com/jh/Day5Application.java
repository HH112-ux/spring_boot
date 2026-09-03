package com.jh;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.jh.mapper")
public class Day5Application {
    public static void main(String[] args) {
        SpringApplication.run(Day5Application.class, args);
    }
}
