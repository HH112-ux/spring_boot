package com.jh;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jh.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class TestActiveRecord {

    @Test
    public void save() {
        Student student = new Student();
        student.setName("学生AAA").setGender("男").setAge(20).setTid(107);
        boolean b = student.insert();
        System.out.println("b = " + b);
    }

    @Test
    public void delete() {
        Student student = new Student();
        student.setId(63);
        boolean b = student.deleteById();
        System.out.println("b = " + b);
    }

    @Test
    public void update() {
        Student student = new Student();
        student.setId(57);
        student.setAge(30);
        boolean b = student.updateById();
        System.out.println("b = " + b);
    }

    @Test
    public void select() {
        Student student = new Student();
        QueryWrapper<Student> wrapper = new QueryWrapper<>();
        wrapper.eq("gender", "男");
        List<Student> students = student.selectList(wrapper);
        students.forEach(System.out::println);
    }
}
