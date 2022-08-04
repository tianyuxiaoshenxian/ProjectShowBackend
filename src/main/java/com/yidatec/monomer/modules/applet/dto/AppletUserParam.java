package com.yidatec.monomer.modules.applet.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * 小程序会员注册参数
 *
 * @author xbr
 * @since 2022-08-4
 */
@Getter
@Setter
public class AppletUserParam {

    @ApiModelProperty(value = "id")
    private String id;
    @ApiModelProperty(value = "用户昵称")
    private String username;
    @ApiModelProperty(value = "真实姓名")
    private String realName;
    @ApiModelProperty(value = "联系方式")
    private String phoneNumber;
    @ApiModelProperty(value = "性别")
    private Integer gender;
    @ApiModelProperty(value = "出生日期")
    private Date birthday;
    @ApiModelProperty(value = "身份证号")
    private Integer idCard;
    @ApiModelProperty(value = "省")
    private Integer province;
    @ApiModelProperty(value = "市")
    private Integer city;
    @ApiModelProperty(value = "详细地址")
    private String detailAddress;
}
