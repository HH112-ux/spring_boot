package com.jh.service;

import com.jh.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> selectList();
    Student selectId(Integer id);
    int save(Student student);
    int update(Student student);
    int delete(Integer id);
}
