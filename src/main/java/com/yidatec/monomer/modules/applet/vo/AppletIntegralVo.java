package com.yidatec.monomer.modules.applet.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


/**
 * 消费记录参数
 *
 * @author xbr
 * @since 2022-08-09
 */
@Getter
@Setter
public class AppletIntegralVo {

    @ApiModelProperty(value = "id")
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

    @ApiModelProperty(value = "创建人")
    private String createUser;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "更新人")
    private String updateUser;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    @ApiModelProperty(value = "删除标志 0:存在 1:删除")
    private Integer del;

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "真实姓名")
    private String realName;

    @ApiModelProperty(value = "手机号")
    private String phoneNumber;

    @ApiModelProperty(value = "身份证号")
    private String idCard;

    @ApiModelProperty(value = "总积分")
    private String integralTotal;

}
