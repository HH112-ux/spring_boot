package com.jh.service;

import com.jh.dao.UsersDao;
import com.jh.entity.Users;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UsersDao dao;

    @Override
    public List<Users> list() {
        return dao.selectList();
    }
}
