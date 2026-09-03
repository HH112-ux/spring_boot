package com.jh.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jh.entity.Emp;
import com.jh.mapper.EmpMapper;
import com.jh.service.EmpService;
import org.springframework.stereotype.Service;

@Service
@DS("slave")
public class EmpServiceImpl extends ServiceImpl<EmpMapper, Emp> implements EmpService {
}
