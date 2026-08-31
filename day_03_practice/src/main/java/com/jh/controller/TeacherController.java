package com.jh.controller;

import com.jh.model.Student;
import com.jh.model.Teacher;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/teacher")
@Api(tags = "教师信息管理")
public class TeacherController {

    @Autowired
    private Teacher teacher;

    @GetMapping("/info")
    @ApiOperation("查询教师信息")
    public String teacherInfo() {
        return "教师姓名：" + teacher.getName() +
                "，性别：" + teacher.getGender() +
                "，年龄：" + teacher.getAge();
    }

    @GetMapping("/students")
    @ApiOperation("查询所有学生")
    public List<Student> students() {
        return teacher.getStudents();
    }

    @GetMapping("/grades")
    @ApiOperation("查询所有学生成绩")
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
    @ApiOperation("查询语文成绩")
    public String chinese() {
        StringBuilder sb = new StringBuilder("语文成绩：\n");
        for (Student s : teacher.getStudents()) {
            sb.append(s.getName()).append("：").append(s.getChinese()).append("分\n");
        }
        return sb.toString();
    }
}
