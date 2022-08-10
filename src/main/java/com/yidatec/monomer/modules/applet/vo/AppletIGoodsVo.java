package com.yidatec.monomer.modules.applet.vo;

import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;


/**
 * 商品返回参数
 *
 * @author xbr
 * @since 2022-08-09
 */
@Getter
@Setter
public class AppletIGoodsVo {

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
