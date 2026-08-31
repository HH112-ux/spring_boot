package com.jh.model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Data
@Component
@ConfigurationProperties(prefix = "com.jh.model.users")
public class Users {

    private String userName;
    private String gender;
    private int age;
    private double money;
    private LocalDate birth;
    private List<Student> stuList;
    private List<Student> stuList1;
}
