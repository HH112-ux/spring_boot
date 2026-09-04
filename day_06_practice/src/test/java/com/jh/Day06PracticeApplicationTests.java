package com.jh;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jh.entity.Employee;
import com.jh.mapper.EmployeeMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class Day06PracticeApplicationTests {

    @Resource
    private EmployeeMapper mapper;

    // 任务一：查询所有年龄在22到30岁的男性员工信息
    @Test
    void task1() {
        QueryWrapper<Employee> wrapper = new QueryWrapper<>();
        wrapper.between("age", 22, 30)
                .eq("gender", "男");
        List<Employee> list = mapper.selectList(wrapper);
        list.forEach(System.out::println);
        System.out.println("共查询到 " + list.size() + " 条记录");
    }

    // 任务二：查询市场部或者是销售部的女性员工信息
    @Test
    void task2() {
        QueryWrapper<Employee> wrapper = new QueryWrapper<>();
        wrapper.eq("gender", "女")
                .in("dept_name", "市场部", "销售部");
        List<Employee> list = mapper.selectList(wrapper);
        list.forEach(System.out::println);
        System.out.println("共查询到 " + list.size() + " 条记录");
    }

    // 任务三：查询地址在长春且工作状态是休息的员工信息
    @Test
    void task3() {
        QueryWrapper<Employee> wrapper = new QueryWrapper<>();
        wrapper.eq("addr", "长春市")
                .eq("status", 1);
        List<Employee> list = mapper.selectList(wrapper);
        list.forEach(System.out::println);
        System.out.println("共查询到 " + list.size() + " 条记录");
    }

    // 任务四：查询所有登录帐号中包含admin字样，且(性别是男或者部门是人事部)
    @Test
    void task4() {
        QueryWrapper<Employee> wrapper = new QueryWrapper<>();
        wrapper.like("login_name", "admin")
                .and(w -> w.eq("gender", "男").or().eq("dept_name", "人事部"));
        List<Employee> list = mapper.selectList(wrapper);
        list.forEach(System.out::println);
        System.out.println("共查询到 " + list.size() + " 条记录");
    }

    // 任务五：查询所有员工信息，按年龄降序排列，分页显示，每页5条
    @Test
    void task5() {
        Page<Employee> page = new Page<>(1, 5);
        QueryWrapper<Employee> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("age");
        mapper.selectPage(page, wrapper);
        List<Employee> records = page.getRecords();
        records.forEach(System.out::println);
        System.out.println("总记录数：" + page.getTotal() + "\t总页数：" + page.getPages()
                + "\t当前页：" + page.getCurrent() + "\t每页显示" + page.getSize() + "条数据\t"
                + "是否有上一页：" + page.hasPrevious() + "\t是否有下一页：" + page.hasNext());
    }
}
