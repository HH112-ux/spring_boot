package com.jh;

import com.jh.entity.Emp;
import com.jh.entity.Teacher;
import com.jh.service.EmpService;
import com.jh.service.TeacherService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
public class TestMulDb {
    @Resource
    private TeacherService teacherService;
    @Resource
    private EmpService empService;

    @Test
    public void selectTeacher() {
        List<Teacher> list = teacherService.list();
        list.forEach(System.out::println);
    }

    @Test
    public void saveEmp() {
        Emp emp = new Emp();
        emp.setName("王某");
        emp.setAddr("南京");
        empService.save(emp);
    }
}
