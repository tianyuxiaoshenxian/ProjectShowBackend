package com.yidatec.monomer.modules.sys.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.core.enums.IEnum;
import lombok.Getter;

@Getter
public enum MenuType implements IEnum<Integer> {

    CATALOGUE(0, "目录"),
    MENU(1, "菜单"),
    BUTTON(2, "权限");

    MenuType(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    @EnumValue
    private final int code;
    private final String desc;

    @Override
    public String toString() {
        return this.desc;
    }
    @Override
    public Integer getValue() {
        return code;
    }

    public static MenuType getType(int code) {
        for (MenuType menuType : MenuType.values()) {
            if (menuType.code == code) {
                return menuType;
            }
        }
        return CATALOGUE;
    }
}
