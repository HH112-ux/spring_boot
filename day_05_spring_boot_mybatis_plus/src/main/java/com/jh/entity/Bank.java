package com.jh.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;

@Data
public class Bank {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String name;
    private Integer money;
    @Version
    private Integer version;
}
