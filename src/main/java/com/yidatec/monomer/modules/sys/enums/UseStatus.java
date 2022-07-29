package com.yidatec.monomer.modules.sys.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.core.enums.IEnum;
import lombok.Getter;

@Getter
public enum UseStatus implements IEnum<Integer> {

    NORMAL(0, "正常"),
    DISABLE(1, "禁用");

    UseStatus(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    @EnumValue
    private int code;
    private String desc;

    @Override
    public String toString() {
        return this.desc;
    }
    @Override
    public Integer getValue() {
        return code;
    }
}
