package com.yidatec.monomer.modules.applet.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 站点添加修改参数
 *
 * @author xbr
 * @since 2022-08-3
 */
@Getter
@Setter
public class SiteParam {

    @ApiModelProperty(value = "医院名称")
    private String hospitalName;
    @ApiModelProperty(value = "医院代号")
    private String hospitalNum;
    @ApiModelProperty(value = "医院条码")
    private String hospitalBarCode;
    @ApiModelProperty(value = "省")
    private String province;
    @ApiModelProperty(value = "市")
    private String city;
    @ApiModelProperty(value = "区")
    private String district;
    @ApiModelProperty(value = "详细地址")
    private String detailAddress;
}
