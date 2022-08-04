package com.yidatec.monomer.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.yidatec.monomer.common.domain.AbstractEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 系统字典表
 * </p>
 *
 * @author xbr
 * @since 2022-05-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_dict")
@ApiModel(value = "SysDict对象", description = "系统字典表")
public class SysDict extends AbstractEntity {

    @ApiModelProperty(value = "父级id")
    private Long fid;

    @ApiModelProperty(value = "字典名称")
    private String name;

    @ApiModelProperty(value = "字典类型")
    private String type;

    @ApiModelProperty(value = "字典码")
    private String code;

    @ApiModelProperty(value = "字典值")
    private String value;

    @ApiModelProperty(value = "排序")
    private Long orderNum;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "删除状态：0->正常；1->已删除")
    private Integer del;

}
