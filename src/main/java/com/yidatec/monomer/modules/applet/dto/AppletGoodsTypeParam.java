package com.yidatec.monomer.modules.applet.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 商品类型参数
 *
 * @author xbr
 * @since 2022-08-09
 */
@Getter
@Setter
public class AppletGoodsTypeParam {

    @ApiModelProperty(value = "id")
    private String id;

    @ApiModelProperty(value = "商品类型名称")
    private String typeName;
}
