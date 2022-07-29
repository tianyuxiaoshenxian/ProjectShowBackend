package com.yidatec.monomer.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.yidatec.monomer.common.domain.AbstractEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 后台菜单表
 * </p>
 *
 * @author xudk
 * @since 2022-05-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_menu")
@ApiModel(value="SysMenu对象", description="后台菜单表")
public class SysMenu extends AbstractEntity {

    @ApiModelProperty(value = "父菜单ID")
    private Long parentId;

    @ApiModelProperty(value = "菜单名称")
    private String name;

    @ApiModelProperty(value = "菜单URL")
    private String url;

    @ApiModelProperty(value = "授权")
    private String perms;

    @ApiModelProperty(value = "类型")
    private Integer type;

    @ApiModelProperty(value = "菜单图标")
    private String icon;

    @ApiModelProperty(value = "排序")
    private Integer sort;

}
