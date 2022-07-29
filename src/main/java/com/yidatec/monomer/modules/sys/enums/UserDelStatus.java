package com.yidatec.monomer.modules.sys.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.core.enums.IEnum;
import lombok.Getter;

@Getter
public enum UserDelStatus implements IEnum<Integer> {

    NORMAL(0, "正常"),
    DELETE(1, "删除");

    UserDelStatus(int code, String desc) {
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
