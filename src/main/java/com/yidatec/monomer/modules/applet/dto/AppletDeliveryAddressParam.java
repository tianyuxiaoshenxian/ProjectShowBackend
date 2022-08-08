package com.yidatec.monomer.modules.applet.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 收货地址参数
 *
 * @author xbr
 * @since 2022-08-08
 */
@Getter
@Setter
public class AppletDeliveryAddressParam {

    @ApiModelProperty(value = "id")
    private String id;

    @ApiModelProperty(value = "会员id")
    private String userId;

    @ApiModelProperty(value = "收件人姓名")
    private String realName;

    @ApiModelProperty(value = "联系电话")
    private String telephone;

    @ApiModelProperty(value = "备用联系电话")
    private String telephone2;

    @ApiModelProperty(value = "省")
    private String province;

    @ApiModelProperty(value = "国家")
    private String country;

    @ApiModelProperty(value = "市")
    private String city;

    @ApiModelProperty(value = "区")
    private String district;

    @ApiModelProperty(value = "详细地址")
    private String detailAddress;

    @ApiModelProperty(value = "邮政编码")
    private String zip;

    @ApiModelProperty(value = "是否默认收货地址")
    private String isDefaultAddress;
}
