package com.jh.controller;

import com.jh.entity.UserAccount;
import com.jh.service.UserAccountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/account")
@Api(tags = "用户账户管理")
public class UserAccountController {

    @Resource
    private UserAccountService userAccountService;

    @PostMapping
    @ApiOperation("新增账户")
    public Boolean save(@RequestBody UserAccount account) {
        return userAccountService.save(account);
    }

    @GetMapping
    @ApiOperation("查询所有账户")
    public Object list() {
        return userAccountService.list();
    }

    @PutMapping
    @ApiOperation("修改账户（乐观锁）")
    public Boolean update(@RequestBody UserAccount account) {
        return userAccountService.updateById(account);
    }
}
