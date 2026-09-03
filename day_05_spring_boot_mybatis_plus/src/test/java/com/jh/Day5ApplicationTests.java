package com.jh;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.mysql.cj.util.StringUtils;
import com.jh.entity.Teacher;
import com.jh.mapper.TeacherMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.*;

@SpringBootTest
class Day5ApplicationTests {

    @Resource
    private TeacherMapper mapper;

    @Test
    void selectList() {
        List<Teacher> list = mapper.selectList(null);
        list.forEach(System.out::println);
    }

    @Test
    void save() {
        Teacher teacher = new Teacher();
        teacher.setTeacherName("李老师").setGender("女").setAge(20);
        mapper.insert(teacher);
    }

    @Test
    void deleteById() {
        Teacher teacher = new Teacher();
        teacher.setId(105);
        int i = mapper.deleteById(teacher);
        System.out.println("i = " + i);
    }

    @Test
    void deleteByMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("teacher_name", "李四");
        map.put("gender", "男");
        int i = mapper.deleteByMap(map);
        System.out.println("i = " + i);
    }

    @Test
    void deleteBatchIds() {
        List<Integer> ids = Arrays.asList(100, 102, 110);
        int i = mapper.deleteBatchIds(ids);
        System.out.println("i = " + i);
    }

    @Test
    void delete() {
        QueryWrapper<Teacher> wrapper = new QueryWrapper<>();
        wrapper.eq("gender", "男")
                .like("teacher_name", "张");
        mapper.delete(wrapper);
    }

    @Test
    void delete1() {
        Teacher teacher = new Teacher();
        teacher.setTeacherName("李四").setGender("女");
        QueryWrapper<Teacher> wrapper = new QueryWrapper<>(teacher);
        mapper.delete(wrapper);
    }

    @Test
    void delete2() {
        LambdaQueryWrapper<Teacher> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(Teacher::getTeacherName, "张")
                .eq(Teacher::getGender, "男");
        mapper.delete(wrapper);
    }

    @Test
    void delete3() {
        Teacher teacher = new Teacher();
        teacher.setTeacherName("张");
        QueryWrapper<Teacher> wrapper = new QueryWrapper<>();
        wrapper.eq(!StringUtils.isNullOrEmpty(teacher.getGender()), "gender", teacher.getGender())
                .like(!StringUtils.isNullOrEmpty(teacher.getTeacherName()), "teacher_name", teacher.getTeacherName());
        mapper.delete(wrapper);
    }

    @Test
    void updateById() {
        Teacher teacher = new Teacher();
        teacher.setAge(30).setGender("女").setId(1);
        mapper.updateById(teacher);
    }

    @Test
    void update() {
        Teacher teacher = new Teacher();
        teacher.setGender("男").setAge(25);
        UpdateWrapper wrapper = new UpdateWrapper();
        wrapper.likeRight("teacher_name", "张");
        mapper.update(teacher, wrapper);
    }

    @Test
    void update1() {
        UpdateWrapper<Teacher> wrapper = new UpdateWrapper<>();
        wrapper.set("gender", "女").set("age", 30)
                .likeRight("teacher_name", "张");
        mapper.update(null, wrapper);
    }

    @Test
    void update2() {
        LambdaUpdateWrapper<Teacher> wrapper = new LambdaUpdateWrapper<>();
        wrapper.set(Teacher::getGender, "女").set(Teacher::getAge, 30)
                .likeRight(Teacher::getTeacherName, "张");
        mapper.update(null, wrapper);
    }
}
