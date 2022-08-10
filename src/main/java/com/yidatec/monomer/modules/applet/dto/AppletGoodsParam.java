package com.yidatec.monomer.modules.applet.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * 商品参数
 *
 * @author xbr
 * @since 2022-08-09
 */
@Getter
@Setter
public class AppletGoodsParam {

    @ApiModelProperty(value = "id")
    private String id;

    @ApiModelProperty(value = "商品名称")
    private String goodsName;

    @ApiModelProperty(value = "商品类型id")
    private String goodsTypeId;

    @ApiModelProperty(value = "商品价格")
    private BigDecimal price;

    @ApiModelProperty(value = "商品图片")
    private String image;

    @ApiModelProperty(value = "商品描述")
    private String description;

    @ApiModelProperty(value = "商品数量")
    private Integer count;

    @ApiModelProperty(value = "状态0：发布待审核，1，审核通过，2下架或违规下架")
    private Integer status;
}
