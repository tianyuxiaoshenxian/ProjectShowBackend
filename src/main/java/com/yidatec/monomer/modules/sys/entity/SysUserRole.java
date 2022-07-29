package com.yidatec.monomer.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("sys_user_role")
@ApiModel(value="SysUserRole对象", description="后台用户角色表")
public class SysUserRole extends AbstractEntity {

    @ApiModelProperty(value = "用户ID")
    private Long userId;

    @ApiModelProperty(value = "角色ID")
    private Long roleId;

}
