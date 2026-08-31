package com.jh.service.impl;

import com.jh.entity.Student;
import com.jh.mapper.StudentMapper;
import com.jh.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Resource
    private StudentMapper mapper;

    @Override
    public List<Student> selectList() {
        return mapper.selectList();
    }

    @Override
    public Student selectId(Integer id) {
        return mapper.selectId(id);
    }

    @Override
    public int save(Student student) {
        return mapper.save(student);
    }

    @Override
    public int update(Student student) {
        return mapper.update(student);
    }

    @Override
    public int delete(Integer id) {
        return mapper.delete(id);
    }
}
