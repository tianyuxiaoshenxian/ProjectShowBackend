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
@TableName("sys_role")
@ApiModel(value="SysRole对象", description="后台角色表")
public class SysRole extends AbstractEntity {

    @ApiModelProperty(value = "角色名")
    private String roleName;

    @ApiModelProperty(value = "角色CODE")
    private String roleCode;

    @ApiModelProperty(value = "备注")
    private String remark;

}
