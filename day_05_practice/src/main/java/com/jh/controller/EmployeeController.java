package com.jh.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.jh.entity.Employee;
import com.jh.service.EmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/emp")
@Api(tags = "员工管理")
public class EmployeeController {

    @Resource
    private EmployeeService employeeService;

    // 任务二：插入数据
    @PostMapping
    @ApiOperation("插入员工")
    public boolean save(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }

    // 任务三：查询所有数据，不显示登录密码
    @GetMapping
    @ApiOperation("查询所有员工（隐藏密码）")
    public List<Employee> list() {
        return employeeService.list();
    }

    // 任务四：将市场部改为销售部
    @PutMapping("/updateDept")
    @ApiOperation("市场部改为销售部")
    public boolean updateDept() {
        UpdateWrapper<Employee> wrapper = new UpdateWrapper<>();
        wrapper.set("dept_name", "销售部")
               .eq("dept_name", "市场部");
        return employeeService.update(wrapper);
    }

    // 任务五：吉林市和长春市，年龄不在30-50之间的，状态改为休息
    @PutMapping("/updateStatus")
    @ApiOperation("吉林市长春市年龄不在30-50的改为休息")
    public boolean updateStatus() {
        UpdateWrapper<Employee> wrapper = new UpdateWrapper<>();
        wrapper.set("status", 1)
               .in("addr", "吉林市", "长春市")
               .notBetween("age", 30, 50);
        return employeeService.update(wrapper);
    }

    // 任务六：删除60岁以上男性员工（逻辑删除）
    @DeleteMapping("/deleteElderly")
    @ApiOperation("删除60岁以上男性员工")
    public boolean deleteElderly() {
        QueryWrapper<Employee> wrapper = new QueryWrapper<>();
        wrapper.gt("age", 60)
               .eq("gender", "男");
        return employeeService.remove(wrapper);
    }
}
