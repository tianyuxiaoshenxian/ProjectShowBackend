package com.yidatec.monomer.modules.applet.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 小程序会员积分记录
 * </p>
 *
 * @author yidatec
 * @since 2022-08-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("applet_integral")
@ApiModel(value = "AppletIntegral对象", description = "小程序会员积分记录")
public class AppletIntegral implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    @TableId(type = IdType.ASSIGN_UUID)
    private String id;

    @ApiModelProperty(value = "用户id")
    private String userId;

    @ApiModelProperty(value = "积分变动")
    private Integer integral;

    @ApiModelProperty(value = "0增加，1减少")
    private Integer type;

    @ApiModelProperty(value = "积分变动原因,0:扫码增加，1：看资讯增加，2：扫码抽奖，3：积分兑换")
    private Integer reason;

    @ApiModelProperty(value = "积分变动原因管理信息，如订单id")
    private String objectId;

    @ApiModelProperty(value = "删除标志 0:存在 1:删除")
    private Integer del;


}
