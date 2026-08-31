package com.jh.controller;

import com.jh.service.TeamService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("team")
@Api(tags = {"团队管理"})
public class TeamController {
    @Resource
    private TeamService service;

    @ApiOperation("显示团队全部信息")
    @GetMapping
    public Object list(){
        return service.selectList();
    }
}
