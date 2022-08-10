package com.yidatec.monomer.modules.applet.vo;

import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;


/**
 * 订单返回参数
 *
 * @author xbr
 * @since 2022-08-09
 */
@Getter
@Setter
public class AppletIOrderVo {

    @ApiModelProperty(value = "id")
    private String id;
    @ApiModelProperty(value = "订单编号")
    private String code;
    @ApiModelProperty(value = "订单状态")
    private String status;
    @ApiModelProperty(value = "商品项目数量")
    private BigDecimal productCount;
    @ApiModelProperty(value = "商品总价（积分）")
    private BigDecimal productAmountTotal;
    @ApiModelProperty(value = "实付金额（积分）")
    private BigDecimal amountTotal;
    @ApiModelProperty(value = "运费")
    private BigDecimal logisticsFee;
    @ApiModelProperty(value = "收货地址id")
    private String addressId;
    @ApiModelProperty(value = "物流编号")
    private String orderLogisticsId;
    @ApiModelProperty(value = "创建人")
    private String createUser;
    @JSONField(format = "yyyy-MM-dd")
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
    @ApiModelProperty(value = "更新人")
    private String updateUser;
    @JSONField(format = "yyyy-MM-dd")
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;
    @ApiModelProperty(value = "删除标志 0:存在 1:删除")
    private Integer del;

}
