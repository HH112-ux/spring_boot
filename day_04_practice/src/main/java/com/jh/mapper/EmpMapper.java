package com.jh.mapper;

import com.jh.entity.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmpMapper {

    int insertEmp(Emp emp);

    int deleteById(@Param("id") Integer id);

    int deleteByCondition(@Param("emp") Emp emp);

    int updateById(Emp emp);

    List<Emp> findAll();

    Emp findById(@Param("id") Integer id);

    List<Emp> findByCondition(@Param("emp") Emp emp);
}
