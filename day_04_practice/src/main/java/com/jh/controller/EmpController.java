package com.jh.controller;

import com.github.pagehelper.PageInfo;
import com.jh.entity.Emp;
import com.jh.service.EmpService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emp")
@Api(tags = "Emp管理-MyBatis")
public class EmpController {

    @Autowired
    private EmpService empService;

    @PostMapping
    @ApiOperation("1.添加记录")
    public String add(@RequestBody Emp emp) {
        int result = empService.addEmp(emp);
        return result > 0 ? "添加成功" : "添加失败";
    }

    @DeleteMapping("/{id}")
    @ApiOperation("2.根据ID删除")
    public String deleteById(@PathVariable Integer id) {
        int result = empService.deleteById(id);
        return result > 0 ? "删除成功" : "删除失败";
    }

    @DeleteMapping("/condition")
    @ApiOperation("3.根据条件删除(思考)")
    public String deleteByCondition(Emp emp) {
        int result = empService.deleteByCondition(emp);
        return result > 0 ? "删除成功" : "删除失败";
    }

    @PutMapping
    @ApiOperation("4.根据ID修改")
    public String update(@RequestBody Emp emp) {
        int result = empService.updateById(emp);
        return result > 0 ? "修改成功" : "修改失败";
    }

    @GetMapping
    @ApiOperation("5.显示所有数据")
    public List<Emp> findAll() {
        return empService.findAll();
    }

    @GetMapping("/page")
    @ApiOperation("6.分页显示所有数据")
    public PageInfo<Emp> findAllByPage(
            @RequestParam(defaultValue = "1") int pageNum,
            @RequestParam(defaultValue = "3") int pageSize) {
        return empService.findAllByPage(pageNum, pageSize);
    }

    @GetMapping("/{id}")
    @ApiOperation("7.根据ID查询")
    public Emp findById(@PathVariable Integer id) {
        return empService.findById(id);
    }

    @GetMapping("/page/condition")
    @ApiOperation("8.分页条件查询(思考)")
    public PageInfo<Emp> findByConditionByPage(
            Emp emp,
            @RequestParam(defaultValue = "1") int pageNum,
            @RequestParam(defaultValue = "3") int pageSize) {
        return empService.findByConditionByPage(emp, pageNum, pageSize);
    }
}
