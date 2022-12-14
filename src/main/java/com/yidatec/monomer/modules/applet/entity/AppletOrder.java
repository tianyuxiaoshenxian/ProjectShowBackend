package com.yidatec.monomer.modules.applet.entity;

import java.math.BigDecimal;

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
 * 订单表
 * </p>
 *
 * @author yidatec
 * @since 2022-08-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("applet_order")
@ApiModel(value = "AppletOrder对象", description = "订单表")
public class AppletOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    @TableId(type = IdType.ASSIGN_UUID)
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

    @ApiModelProperty(value = "删除标志 0:存在 1:删除")
    private Integer del;

}
