package com.yidatec.monomer.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.yidatec.monomer.common.domain.AbstractEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 后台角色菜单表
 * </p>
 *
 * @author xudk
 * @since 2022-05-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_role_menu")
@ApiModel(value = "SysRoleMenu对象", description = "后台角色菜单表")
public class SysRoleMenu extends AbstractEntity {

    @ApiModelProperty(value = "角色ID")
    private Long roleId;

    @ApiModelProperty(value = "菜单ID")
    private Long menuId;

}
