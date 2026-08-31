package com.jh.controller;

import com.jh.model.Student;
import com.jh.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private Teacher teacher;

    @GetMapping("/info")
    public String teacherInfo() {
        return "教师姓名：" + teacher.getName() +
                "，性别：" + teacher.getGender() +
                "，年龄：" + teacher.getAge();
    }

    @GetMapping("/students")
    public List<Student> students() {
        return teacher.getStudents();
    }

    @GetMapping("/grades")
    public String grades() {
        StringBuilder sb = new StringBuilder();
        for (Student s : teacher.getStudents()) {
            sb.append(s.getName())
              .append(" - 语文：").append(s.getChinese())
              .append("，数学：").append(s.getMath())
              .append("，英语：").append(s.getEnglish())
              .append("\n");
        }
        return sb.toString();
    }

    @GetMapping("/chinese")
    public String chinese() {
        StringBuilder sb = new StringBuilder("语文成绩：\n");
        for (Student s : teacher.getStudents()) {
            sb.append(s.getName()).append("：").append(s.getChinese()).append("分\n");
        }
        return sb.toString();
    }
}
