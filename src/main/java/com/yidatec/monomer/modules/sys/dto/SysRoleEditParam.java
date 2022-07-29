package com.yidatec.monomer.modules.sys.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * 角色修改参数
 * @author xudk
 * @since 2022-05-24
 */
@Getter
@Setter
public class SysRoleEditParam {
    @ApiModelProperty(value = "id")
    private Long id;
    @ApiModelProperty(value = "角色编码")
    private String roleCode;
    @ApiModelProperty(value = "角色名称")
    private String roleName;
    @ApiModelProperty(value = "新增菜单ID")
    List<Long> addMenuIds;
    @ApiModelProperty(value = "删除菜单ID")
    List<Long> delMenuIds;
}
