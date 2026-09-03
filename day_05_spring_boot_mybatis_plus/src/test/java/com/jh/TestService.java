package com.jh;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jh.entity.Teacher;
import com.jh.service.TeacherService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
public class TestService {
    @Resource
    private TeacherService service;

    @Test
    public void testSelect() {
        List<Teacher> list = service.list();
        list.forEach(System.out::println);
    }

    @Test
    public void testSelectCondition() {
        QueryWrapper<Teacher> wrapper = new QueryWrapper<>();
        wrapper.like("teacher_name", "张");
        List<Teacher> list = service.list(wrapper);
        list.forEach(System.out::println);
    }

    @Test
    public void testSave() {
        Teacher teacher = new Teacher();
        teacher.setTeacherName("周老师").setAge(30).setGender("男");
        boolean b = service.save(teacher);
        System.out.println(b);
    }

    @Test
    public void testSaveOrUpdate() {
        Teacher teacher = new Teacher();
        teacher.setId(109).setTeacherName("刘老师").setAge(40).setGender("女");
        boolean b = service.updateById(teacher);
        System.out.println(b);
    }

    @Test
    public void testRemove() {
        boolean b = service.removeById(109);
        System.out.println(b);
    }

    @Test
    public void testGet() {
        Teacher teacher = service.getById(108);
        System.out.println(teacher);
        System.out.println("____________________");
    }

    @Test
    public void testPage() {
        Page<Teacher> page = new Page<>(1, 3);
        service.page(page);
        List<Teacher> records = page.getRecords();
        records.forEach(System.out::println);
        System.out.println("总数据量:" + page.getTotal());
    }
}
