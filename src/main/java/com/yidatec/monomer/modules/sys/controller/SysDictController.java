package com.yidatec.monomer.modules.sys.controller;

import com.yidatec.monomer.common.api.CommonResult;
import com.yidatec.monomer.modules.sys.entity.SysDict;
import com.yidatec.monomer.modules.sys.service.SysDictService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 后台字典管理
 *
 * @author xbr
 * @since 2022-05-30
 */
@RestController
@Api(tags = "SysDictController", description = "后台字典管理")
@RequestMapping("/sys/dict")
public class SysDictController {

    @Autowired
    private SysDictService sysDictService;

    @ApiOperation(value = "查询字典")
    @GetMapping(value = "/getDictByQuery")
    public CommonResult<List<SysDict>> getDictByQuery(
            @RequestParam(value = "type") Long type,
            @RequestParam(value = "fid", required = false) Long fid) {
        return CommonResult.success(sysDictService.getDictByQuery(type, fid));
    }

    @ApiOperation(value = "查询字典通过类型")
    @GetMapping(value = "/getDictByType")
    public CommonResult<List<SysDict>> getDictByType(
            @RequestParam(value = "type") Long type) {
        return CommonResult.success(sysDictService.getDictByType(type));
    }


}
