package com.yidatec.monomer.modules.sys.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 字典添加修改参数
 *
 * @author xbr
 * @since 2022-05-24
 */
@Getter
@Setter
public class SysDictParam {

    @ApiModelProperty(value = "id")
    private Long id;
    @ApiModelProperty(value = "父级id")
    private Long fid;
    @ApiModelProperty(value = "字典名称")
    private String name;
    @ApiModelProperty(value = "字典类型")
    private Long type;
    @ApiModelProperty(value = "字典码")
    private String code;
    @ApiModelProperty(value = "字典值")
    private String value;
    @ApiModelProperty(value = "排序")
    private Long orderNum;
    @ApiModelProperty(value = "备注")
    private String remark;
}
