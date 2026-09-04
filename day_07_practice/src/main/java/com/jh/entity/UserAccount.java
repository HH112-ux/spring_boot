package com.jh.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@TableName("user_account")
public class UserAccount {
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;
    private String name;
    private Integer balance;
    @Version
    private Integer version;
}
