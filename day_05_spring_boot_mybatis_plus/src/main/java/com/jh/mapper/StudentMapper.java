package com.jh.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jh.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentMapper extends BaseMapper<Student> {
    List<Student> selectCustomer();
    Page<Student> selectCustomerPage(@Param("page") Page page, @Param("age") int age);
}
