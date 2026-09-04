package com.jh.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jh.entity.Employee;
import com.jh.service.EmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/emp")
@Api(tags = "员工查询管理")
public class EmployeeController {

    @Resource
    private EmployeeService employeeService;

    // 任务一：查询所有年龄在22到30岁的男性员工信息
    @GetMapping("/task1")
    @ApiOperation("22-30岁男性员工")
    public Object task1() {
        QueryWrapper<Employee> wrapper = new QueryWrapper<>();
        wrapper.between("age", 22, 30)
               .eq("gender", "男");
        List<Employee> list = employeeService.list(wrapper);
        log.info("任务一：22-30岁男性员工，查询到 {} 条记录", list.size());
        list.forEach(e -> log.info("  - {}，{}岁，{}，{}", e.getEmpName(), e.getAge(), e.getGender(), e.getDeptName()));
        return list;
    }

    // 任务二：查询市场部或者是销售部的女性员工信息
    @GetMapping("/task2")
    @ApiOperation("市场部或销售部女性员工")
    public Object task2() {
        QueryWrapper<Employee> wrapper = new QueryWrapper<>();
        wrapper.eq("gender", "女")
               .in("dept_name", "市场部", "销售部");
        List<Employee> list = employeeService.list(wrapper);
        log.info("任务二：市场部或销售部女性员工，查询到 {} 条记录", list.size());
        list.forEach(e -> log.info("  - {}，{}，{}，{}", e.getEmpName(), e.getGender(), e.getDeptName(), e.getAddr()));
        return list;
    }

    // 任务三：查询地址在长春且工作状态是休息的员工信息
    @GetMapping("/task3")
    @ApiOperation("长春且休息状态员工")
    public Object task3() {
        QueryWrapper<Employee> wrapper = new QueryWrapper<>();
        wrapper.eq("addr", "长春市")
               .eq("status", 1);
        List<Employee> list = employeeService.list(wrapper);
        log.info("任务三：长春且休息状态员工，查询到 {} 条记录", list.size());
        list.forEach(e -> log.info("  - {}，{}，{}，状态：{}", e.getEmpName(), e.getAddr(), e.getDeptName(), e.getStatus()));
        return list;
    }

    // 任务四：查询所有登录帐号中包含admin字样，且(性别是男或者部门是人事部)
    @GetMapping("/task4")
    @ApiOperation("登录帐号含admin且(男或人事部)")
    public Object task4() {
        QueryWrapper<Employee> wrapper = new QueryWrapper<>();
        wrapper.like("login_name", "admin")
               .and(w -> w.eq("gender", "男").or().eq("dept_name", "人事部"));
        List<Employee> list = employeeService.list(wrapper);
        log.info("任务四：登录帐号含admin且(男或人事部)，查询到 {} 条记录", list.size());
        list.forEach(e -> log.info("  - {}，帐号：{}，{}，{}", e.getEmpName(), e.getLoginName(), e.getGender(), e.getDeptName()));
        return list;
    }

    // 任务五：查询所有员工信息，按年龄降序排列，分页显示，每页5条
    @GetMapping("/task5")
    @ApiOperation("按年龄降序分页每页5条")
    public Object task5(@RequestParam(defaultValue = "1") Integer current) {
        Page<Employee> page = new Page<>(current, 5);
        QueryWrapper<Employee> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("age");
        Page<Employee> result = employeeService.page(page, wrapper);
        log.info("任务五：按年龄降序分页，第{}页，每页5条，共{}条记录，{}页", current, result.getTotal(), result.getPages());
        result.getRecords().forEach(e -> log.info("  - {}，{}岁，{}", e.getEmpName(), e.getAge(), e.getDeptName()));
        return result;
    }
}
