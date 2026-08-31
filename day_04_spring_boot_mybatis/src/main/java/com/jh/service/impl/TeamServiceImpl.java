package com.jh.service.impl;

import com.jh.entity.Team;
import com.jh.mapper.TeamMapper;
import com.jh.service.TeamService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TeamServiceImpl implements TeamService {
    @Resource
    private TeamMapper mapper;

    @Override
    public List<Team> selectList() {
        return mapper.selectList();
    }
}
