package com.jh;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.jh.entity.Employee;
import com.jh.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class Day05PracticeApplicationTests {

    @Resource
    private EmployeeService employeeService;

    // 任务二：插入数据
    @Test
    void testInsert() {
        Employee emp = new Employee();
        emp.setEmpName("测试员工");
        emp.setLoginName("test01");
        emp.setLoginPassword("123456");
        emp.setAge(20);
        emp.setGender("男");
        emp.setAddr("北京市");
        emp.setDeptName("研发部");
        employeeService.save(emp);
        System.out.println("插入成功：" + emp);
    }

    // 任务三：查询所有，隐藏密码
    @Test
    void testSelectAll() {
        List<Employee> list = employeeService.list();
        list.forEach(e -> System.out.println(e.getId() + "\t" + e.getEmpName()
                + "\t" + e.getAge() + "\t" + e.getAddr() + "\t" + e.getDeptName()
                + "\t密码：" + e.getLoginPassword()));
    }

    // 任务四：市场部改为销售部
    @Test
    void testUpdateDept() {
        UpdateWrapper<Employee> wrapper = new UpdateWrapper<>();
        wrapper.set("dept_name", "销售部").eq("dept_name", "市场部");
        boolean result = employeeService.update(wrapper);
        System.out.println("修改结果：" + result);
    }

    // 任务五：吉林市和长春市，年龄不在30-50之间，状态改为休息
    @Test
    void testUpdateStatus() {
        UpdateWrapper<Employee> wrapper = new UpdateWrapper<>();
        wrapper.set("status", 1)
               .in("addr", "吉林市", "长春市")
               .notBetween("age", 30, 50);
        boolean result = employeeService.update(wrapper);
        System.out.println("修改结果：" + result);
    }

    // 任务六：删除60岁以上男性员工（逻辑删除）
    @Test
    void testDeleteElderly() {
        QueryWrapper<Employee> wrapper = new QueryWrapper<>();
        wrapper.gt("age", 60).eq("gender", "男");
        boolean result = employeeService.remove(wrapper);
        System.out.println("删除结果：" + result);
    }
}
