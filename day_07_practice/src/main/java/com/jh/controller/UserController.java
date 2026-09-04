package com.jh.controller;

import com.jh.entity.User;
import com.jh.enums.StatusEnum;
import com.jh.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
@Api(tags = "用户管理")
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping
    @ApiOperation("新增用户")
    public Boolean save(@RequestBody User user) {
        user.setStatus(StatusEnum.ACTIVE);
        return userService.save(user);
    }

    @GetMapping
    @ApiOperation("查询所有用户")
    public Object list() {
        return userService.list();
    }

    @PutMapping
    @ApiOperation("修改用户")
    public Boolean update(@RequestBody User user) {
        return userService.updateById(user);
    }
}
