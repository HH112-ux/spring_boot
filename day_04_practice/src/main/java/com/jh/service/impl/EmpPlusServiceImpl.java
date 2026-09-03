package com.jh.service.impl;

import com.jh.entity.Emp;
import com.jh.mapper.EmpPlusMapper;
import com.jh.service.EmpPlusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpPlusServiceImpl implements EmpPlusService {

    @Autowired
    private EmpPlusMapper empPlusMapper;

    @Override
    public int addEmp(Emp emp) {
        return empPlusMapper.insert(emp);
    }

    @Override
    public int deleteById(Integer id) {
        return empPlusMapper.deleteById(id);
    }

    @Override
    public List<Emp> findAll() {
        return empPlusMapper.selectList(null);
    }
}
