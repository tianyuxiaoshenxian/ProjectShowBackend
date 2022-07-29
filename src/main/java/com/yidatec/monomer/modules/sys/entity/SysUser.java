package com.yidatec.monomer.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.yidatec.monomer.common.domain.AbstractEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 后台用户表
 * </p>
 *
 * @author xudk
 * @since 2022-05-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_user")
@ApiModel(value="SysUser对象", description="后台用户表")
public class SysUser extends AbstractEntity {

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "密码")
    @JsonIgnore
    private String password;

    @ApiModelProperty(value = "真实姓名")
    private String realName;

    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "电话")
    private String mobile;

    @ApiModelProperty(value = "性别：1->男；2->女")
    private Integer sex;

    @ApiModelProperty(value = "帐号启用状态：1->禁用；0->正常")
    private Integer status;

    @ApiModelProperty(value = "删除状态：0->正常；1->已删除")
    private Integer del;

}
