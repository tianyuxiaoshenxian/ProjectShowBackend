package com.yidatec.monomer.modules.sys.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yidatec.monomer.common.api.CommonPage;
import com.yidatec.monomer.common.api.CommonResult;
import com.yidatec.monomer.modules.sys.dto.SysDictParam;
import com.yidatec.monomer.modules.sys.entity.SysDict;
import com.yidatec.monomer.modules.sys.service.SysDictService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.yidatec.monomer.common.constant.Const._DEFAULT_PAGE_NUM;
import static com.yidatec.monomer.common.constant.Const._DEFAULT_PAGE_SIZE;

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

    @ApiOperation(value = "查询父级列表")
    @GetMapping(value = "/fidList")
    public CommonResult<List<SysDict>> fidList() {
        return CommonResult.success(sysDictService.fidList());
    }

    @ApiOperation(value = "查询字典列表")
    @GetMapping(value = "/list")
    public CommonResult<CommonPage<SysDict>> list(
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "type", required = false) Integer type,
            @RequestParam(value = "code", required = false) Integer code,
            @RequestParam(value = "value", required = false) String value,
            @RequestParam(value = "remark", required = false) String remark,
            @RequestParam(value = "pageSize", defaultValue = _DEFAULT_PAGE_SIZE) Integer pageSize,
            @RequestParam(value = "pageNum", defaultValue = _DEFAULT_PAGE_NUM) Integer pageNum) {
        Page<SysDict> sysDictPage = sysDictService.list(name, type, code, value, remark, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(sysDictPage));
    }

    @ApiOperation(value = "添加字典")
    @PostMapping(value = "/add")
    public CommonResult<SysDict> add(@Validated @RequestBody SysDictParam sysDictParam) {
        SysDict dict = sysDictService.addSysDict(sysDictParam);
        if (null == dict) {
            return CommonResult.failed();
        }
        return CommonResult.success(dict);
    }

    @ApiOperation(value = "修改字典")
    @PostMapping(value = "/edit")
    public CommonResult<SysDict> edit(@Validated @RequestBody SysDictParam sysDictParam) {
        SysDict dict = sysDictService.editSysDict(sysDictParam);
        if (null == dict) {
            return CommonResult.failed();
        }
        return CommonResult.success(dict);
    }

    @ApiOperation(value = "删除字典")
    @PostMapping(value = "/delete/{id}")
    public CommonResult delete(@PathVariable Long id) {
        return sysDictService.delete(id);
    }


}
