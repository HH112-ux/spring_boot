package com.jh.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jh.entity.UserAccount;
import com.jh.mapper.UserAccountMapper;
import com.jh.service.UserAccountService;
import org.springframework.stereotype.Service;

@Service
@DS("db2")
public class UserAccountServiceImpl extends ServiceImpl<UserAccountMapper, UserAccount> implements UserAccountService {
}
