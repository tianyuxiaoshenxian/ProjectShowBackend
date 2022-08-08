package com.yidatec.monomer.modules.applet.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

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
@ApiModel(value="AppletIntegral对象", description="小程序会员积分记录")
public class AppletIntegral implements Serializable {

    private static final long serialVersionUID=1L;

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


}
