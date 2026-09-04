package com.jh.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;

public enum StatusEnum {
    ACTIVE(0, "正常"),
    INACTIVE(1, "停用");

    @EnumValue
    private final int code;
    private final String desc;

    StatusEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
