package com.jh.service;

import com.github.pagehelper.PageInfo;
import com.jh.entity.Emp;

import java.util.List;

public interface EmpService {

    int addEmp(Emp emp);

    int deleteById(Integer id);

    int deleteByCondition(Emp emp);

    int updateById(Emp emp);

    List<Emp> findAll();

    PageInfo<Emp> findAllByPage(int pageNum, int pageSize);

    Emp findById(Integer id);

    PageInfo<Emp> findByConditionByPage(Emp emp, int pageNum, int pageSize);
}
