package com.yidatec.monomer.modules.sys.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * 角色添加参数
 * @author xudk
 * @since 2022-05-24
 */
@Getter
@Setter
public class SysMenuTree implements Serializable {

    private static final long serialVersionUID = -1L;

    @ApiModelProperty(value = "id")
    private Long id;

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

    @ApiModelProperty(value = "已选")
    private Boolean checked;

    @ApiModelProperty(value = "路径")
    private String path;
    @ApiModelProperty(value = "组件")
    private String component;
    @ApiModelProperty(value = "媒体名字")
    private String meta;
    @ApiModelProperty(value = "路由名称")
    private String title;
    @ApiModelProperty(value = "是否一直显示")
    private Integer alwaysShow;
    @ApiModelProperty(value = "是否隐藏菜单")
    private Integer hidden;

    @ApiModelProperty(value = "子菜单")
    private List<SysMenuTree> children;
}
