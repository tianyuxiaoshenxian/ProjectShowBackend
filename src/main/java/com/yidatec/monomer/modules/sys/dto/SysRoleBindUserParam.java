package com.yidatec.monomer.modules.sys.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 用户添加修改参数
 *
 * @author xudk
 * @since 2022-05-24
 */
@Getter
@Setter
public class SysRoleBindUserParam {
    @ApiModelProperty(value = "角色ID")
    private Long roleId;
    @ApiModelProperty(value = "Add用户集合")
    private List<Long> addUserList;
    @ApiModelProperty(value = "Delete用户集合")
    private List<Long> delUserList;
}
