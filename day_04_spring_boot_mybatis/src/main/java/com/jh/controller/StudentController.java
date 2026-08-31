package com.jh.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jh.entity.Student;
import com.jh.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("student")
@Api(tags = {"学生管理控制器"})
public class StudentController {
    @Resource
    private StudentService service;

    @ApiOperation("分页显示学生信息")
    @GetMapping("/{start}/{size}")
    public Object listByPage(@PathVariable Integer start, @PathVariable Integer size){
        PageHelper.startPage(start, size);
        List<Student> list = service.selectList();
        PageInfo<Student> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @ApiOperation("显示全部学生信息")
    @GetMapping
    public Object list(){
        List<Student> list = service.selectList();
        return list;
    }

    @ApiOperation("按给定id显示学生信息")
    @GetMapping("/{id}")
    public Object selectId(@PathVariable Integer id){
        Student student = service.selectId(id);
        return student;
    }

    @ApiOperation("保存学生信息")
    @PostMapping
    public Object save(@RequestBody Student student){
        int i = service.save(student);
        return i;
    }

    @ApiOperation("修改学生信息")
    @PutMapping
    public Object update(@RequestBody Student student){
        int i = service.update(student);
        return i;
    }

    @ApiOperation("按给定id删除学生信息")
    @DeleteMapping("/{id}")
    public Object delete(@PathVariable Integer id){
        int i = service.delete(id);
        return i;
    }
}
