package com.jh.controller;

import com.jh.entity.Emp;
import com.jh.service.EmpPlusService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empPlus")
@Api(tags = "Emp管理-MyBatis-Plus")
public class EmpPlusController {

    @Autowired
    private EmpPlusService empPlusService;

    @PostMapping
    @ApiOperation("1.添加记录")
    public String add(@RequestBody Emp emp) {
        int result = empPlusService.addEmp(emp);
        return result > 0 ? "添加成功" : "添加失败";
    }

    @DeleteMapping("/{id}")
    @ApiOperation("2.根据ID删除")
    public String deleteById(@PathVariable Integer id) {
        int result = empPlusService.deleteById(id);
        return result > 0 ? "删除成功" : "删除失败";
    }

    @GetMapping
    @ApiOperation("3.显示所有数据")
    public List<Emp> findAll() {
        return empPlusService.findAll();
    }
}
