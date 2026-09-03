package com.jh.service;

import com.jh.entity.Emp;

import java.util.List;

public interface EmpPlusService {

    int addEmp(Emp emp);

    int deleteById(Integer id);

    List<Emp> findAll();
}
