package com.jh.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;

public enum StatusEnum {
    IN(0, "入库"),
    OUT(1, "出库");

    StatusEnum(Integer statusValue, String statusDesc) {
        this.statusValue = statusValue;
        this.statusDesc = statusDesc;
    }

    @EnumValue
    private final Integer statusValue;
    private final String statusDesc;

    public String toString() {
        return this.statusDesc;
    }
}
