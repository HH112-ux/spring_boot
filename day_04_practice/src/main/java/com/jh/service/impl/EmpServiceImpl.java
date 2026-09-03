package com.jh.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jh.entity.Emp;
import com.jh.mapper.EmpMapper;
import com.jh.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;

    @Override
    public int addEmp(Emp emp) {
        return empMapper.insertEmp(emp);
    }

    @Override
    public int deleteById(Integer id) {
        return empMapper.deleteById(id);
    }

    @Override
    public int deleteByCondition(Emp emp) {
        return empMapper.deleteByCondition(emp);
    }

    @Override
    public int updateById(Emp emp) {
        return empMapper.updateById(emp);
    }

    @Override
    public List<Emp> findAll() {
        return empMapper.findAll();
    }

    @Override
    public PageInfo<Emp> findAllByPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Emp> list = empMapper.findAll();
        return new PageInfo<>(list);
    }

    @Override
    public Emp findById(Integer id) {
        return empMapper.findById(id);
    }

    @Override
    public PageInfo<Emp> findByConditionByPage(Emp emp, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Emp> list = empMapper.findByCondition(emp);
        return new PageInfo<>(list);
    }
}
