package com.yidatec.monomer.modules.applet.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * 积分参数
 *
 * @author xbr
 * @since 2022-08-5
 */
@Getter
@Setter
public class AppletIntegralParam {

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
}
