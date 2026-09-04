package com.jh;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jh.entity.Employee;
import com.jh.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class Day06PracticeApplicationTests {

    @Resource
    private EmployeeService employeeService;

    // 任务一：22-30岁男性员工
    @Test
    void test1() {
        QueryWrapper<Employee> wrapper = new QueryWrapper<>();
        wrapper.between("age", 22, 30).eq("gender", "男");
        employeeService.list(wrapper).forEach(System.out::println);
    }

    // 任务二：市场部或销售部女性员工
    @Test
    void test2() {
        QueryWrapper<Employee> wrapper = new QueryWrapper<>();
        wrapper.eq("gender", "女").in("dept_name", "市场部", "销售部");
        employeeService.list(wrapper).forEach(System.out::println);
    }

    // 任务三：长春且休息状态
    @Test
    void test3() {
        QueryWrapper<Employee> wrapper = new QueryWrapper<>();
        wrapper.eq("addr", "长春市").eq("status", 1);
        employeeService.list(wrapper).forEach(System.out::println);
    }

    // 任务四：登录帐号含admin且(男或人事部)
    @Test
    void test4() {
        QueryWrapper<Employee> wrapper = new QueryWrapper<>();
        wrapper.like("login_name", "admin")
               .and(w -> w.eq("gender", "男").or().eq("dept_name", "人事部"));
        employeeService.list(wrapper).forEach(System.out::println);
    }

    // 任务五：按年龄降序分页每页5条
    @Test
    void test5() {
        Page<Employee> page = new Page<>(1, 5);
        QueryWrapper<Employee> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("age");
        employeeService.page(page, wrapper).getRecords().forEach(System.out::println);
        System.out.println("总记录数：" + page.getTotal() + " 总页数：" + page.getPages());
    }
}
