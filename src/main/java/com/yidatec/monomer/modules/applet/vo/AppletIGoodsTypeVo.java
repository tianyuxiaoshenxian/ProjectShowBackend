package com.yidatec.monomer.modules.applet.vo;

import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


/**
 * 商品类型返回参数
 *
 * @author xbr
 * @since 2022-08-09
 */
@Getter
@Setter
public class AppletIGoodsTypeVo {

    @ApiModelProperty(value = "id")
    private String id;
    @ApiModelProperty(value = "商品类型名称")
    private String typeName;
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
