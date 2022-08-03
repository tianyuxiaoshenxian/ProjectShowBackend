package com.yidatec.monomer.modules.sys.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * 用户添加修改参数
 *
 * @author xudk
 * @since 2022-05-24
 */
@Getter
@Setter
public class SysUserEditParam {
    @ApiModelProperty(value = "id")
    private Long id;
    @NotEmpty
    @ApiModelProperty(value = "账号")
    private String username;
    @NotEmpty
    @ApiModelProperty(value = "姓名")
    private String realName;
    @Email
    @NotEmpty
    @ApiModelProperty(value = "邮箱")
    private String email;
    @NotEmpty
    @ApiModelProperty(value = "手机")
    private String mobile;
    @NotNull
    @ApiModelProperty(value = "性别 1:男 2:女")
    private Integer sex;
    @NotNull
    @ApiModelProperty(value = "状态 1:禁用 0:正常")
    private Integer status;
}
