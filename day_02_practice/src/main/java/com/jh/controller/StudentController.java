package com.jh.controller;

import com.jh.model.Student;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 任务1：模拟学生模块的 CRUD
 * 任务2：RESTful 风格
 *   GET    /student       查询全部
 *   GET    /student/{id}  按ID查询
 *   POST   /student       新增
 *   PUT    /student        修改
 *   DELETE /student/{id}   删除
 */
@RestController
@RequestMapping("/student")
@Api(tags = {"学生管理"})
public class StudentController {

    @GetMapping
    @ApiOperation(value = "查询全部学生")
    public List<Student> list() {
        List<Student> list = new ArrayList<>();
        list.add(new Student(1, "张三", "男", 20));
        list.add(new Student(2, "李四", "女", 22));
        list.add(new Student(3, "王五", "男", 23));
        return list;
    }

    @GetMapping("/{id}")
    @ApiOperation("按给定ID查询学生")
    @ApiImplicitParams(
        @ApiImplicitParam(name = "id", value = "学生ID", required = true, paramType = "path", dataTypeClass = Integer.class)
    )
    public Student selectById(@PathVariable Integer id) {
        return new Student(id, "张三", "男", 20);
    }

    @PostMapping
    @ApiOperation("新增学生")
    public Student save(@RequestBody Student student) {
        student.setId(100);
        return student;
    }

    @PutMapping
    @ApiOperation("修改学生")
    public Student update(@RequestBody Student student) {
        return student;
    }

    @DeleteMapping("/{id}")
    @ApiOperation("按给定ID删除学生")
    @ApiImplicitParams(
        @ApiImplicitParam(name = "id", value = "学生ID", required = true, paramType = "path", dataTypeClass = Integer.class)
    )
    public String deleteById(@PathVariable Integer id) {
        return "已删除ID为 " + id + " 的学生";
    }
}
