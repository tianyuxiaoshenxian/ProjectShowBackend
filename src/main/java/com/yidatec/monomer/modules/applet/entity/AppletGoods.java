package com.yidatec.monomer.modules.applet.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 商品表
 * </p>
 *
 * @author yidatec
 * @since 2022-08-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("applet_goods")
@ApiModel(value = "AppletGoods对象", description = "商品表")
public class AppletGoods implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    @TableId(type = IdType.ASSIGN_UUID)
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

    @ApiModelProperty(value = "删除状态：0->正常；1->已删除")
    private Integer del;


}
