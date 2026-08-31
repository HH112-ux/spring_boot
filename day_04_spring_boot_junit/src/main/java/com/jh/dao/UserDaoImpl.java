package com.jh.dao;

import com.jh.entity.Users;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDaoImpl implements UsersDao {
    @Override
    public List<Users> selectList() {
        List<Users> list = new ArrayList<>();
        list.add(new Users(1, "张三", "男", 23));
        list.add(new Users(2, "李四", "男", 20));
        list.add(new Users(3, "王五", "女", 22));
        list.add(new Users(4, "赵六", "男", 20));
        return list;
    }
}
