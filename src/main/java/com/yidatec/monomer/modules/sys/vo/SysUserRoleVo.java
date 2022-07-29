package com.yidatec.monomer.modules.sys.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

/**
 * 用户添加修改参数
 * @author xudk
 * @since 2022-05-24
 */
@Getter
@Setter
public class SysUserRoleVo {
    @NotEmpty
    @ApiModelProperty(value = "账号", required = true)
    private String username;
    @ApiModelProperty(value = "姓名")
    private String realName;
    @Email
    @ApiModelProperty(value = "邮箱")
    private String email;
    @ApiModelProperty(value = "手机")
    private String mobile;
    @ApiModelProperty(value = "性别 1:男 2:女")
    private Integer sex;
    @ApiModelProperty(value = "状态 1:禁用 0:正常")
    private Integer status;
    @ApiModelProperty(value = "当前角色")
    private String role;
}
