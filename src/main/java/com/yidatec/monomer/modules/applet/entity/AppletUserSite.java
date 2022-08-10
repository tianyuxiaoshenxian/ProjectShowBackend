package com.yidatec.monomer.modules.applet.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;
import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 小程序用户站点关联表
 * </p>
 *
 * @author yidatec
 * @since 2022-08-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("applet_user_site")
@ApiModel(value = "AppletUserSite对象", description = "小程序用户站点关联表")
public class AppletUserSite implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    @TableId(type = IdType.ASSIGN_UUID)
    private String id;

    @ApiModelProperty(value = "会员id")
    private String userId;

    @ApiModelProperty(value = "站点id")
    private String siteId;

    @ApiModelProperty(value = "删除标志 0:存在 1:删除")
    private Integer del;


}
