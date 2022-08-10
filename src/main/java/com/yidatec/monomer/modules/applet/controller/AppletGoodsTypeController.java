package com.yidatec.monomer.modules.applet.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sun.org.apache.bcel.internal.generic.RETURN;
import com.yidatec.monomer.common.api.CommonPage;
import com.yidatec.monomer.common.api.CommonResult;
import com.yidatec.monomer.modules.applet.dto.AppletGoodsTypeParam;
import com.yidatec.monomer.modules.applet.entity.AppletGoodsType;
import com.yidatec.monomer.modules.applet.service.AppletGoodsTypeService;
import com.yidatec.monomer.modules.applet.vo.AppletIGoodsTypeVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.yidatec.monomer.common.constant.Const._DEFAULT_PAGE_NUM;
import static com.yidatec.monomer.common.constant.Const._DEFAULT_PAGE_SIZE;

/**
 * <p>
 * 商品类型表 前端控制器
 * </p>
 *
 * @author yidatec
 * @since 2022-08-08
 */
@RestController
@Api(tags = "AppletGoodsTypeController", description = "商品类型管理")
@RequestMapping("/applet/appletGoodsType")
public class AppletGoodsTypeController {
    @Autowired
    private AppletGoodsTypeService appletGoodsTypeService;

    @ApiOperation(value = "查询商品类型")
    @GetMapping(value = "/list")
    public CommonResult<CommonPage<AppletIGoodsTypeVo>> list(
            @RequestParam(value = "typeName", required = false) String typeName,
            @RequestParam(value = "pageSize", defaultValue = _DEFAULT_PAGE_SIZE) Integer pageSize,
            @RequestParam(value = "pageNum", defaultValue = _DEFAULT_PAGE_NUM) Integer pageNum) {
        Page<AppletIGoodsTypeVo> appletGoodsType = appletGoodsTypeService.list(typeName, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(appletGoodsType));
    }

    @ApiOperation(value = "商品类型")
    @GetMapping(value = "getList")
    public CommonResult<List<AppletGoodsType>> getList(){
        return CommonResult.success(appletGoodsTypeService.list());
    }

    @ApiOperation(value = "添加商品类型")
    @PostMapping(value = "/add")
    public CommonResult<AppletGoodsType> add(@Validated @RequestBody AppletGoodsTypeParam appletGoodsTypeParam) {
        AppletGoodsType appletGoodsType = appletGoodsTypeService.add(appletGoodsTypeParam);
        if (null == appletGoodsType) {
            return CommonResult.failed();
        }
        return CommonResult.success(appletGoodsType);
    }

    @ApiOperation(value = "修改商品类型")
    @PostMapping(value = "/update")
    public CommonResult<AppletGoodsType> update(@Validated @RequestBody AppletGoodsTypeParam appletGoodsTypeParam) {
        AppletGoodsType appletGoodsType = appletGoodsTypeService.update(appletGoodsTypeParam);
        if (null == appletGoodsType) {
            return CommonResult.failed();
        }
        return CommonResult.success(appletGoodsType);
    }

    @ApiOperation(value = "删除商品类型")
    @PostMapping(value = "/delete/{id}")
    public CommonResult delete(@PathVariable String id) {
        return appletGoodsTypeService.delete(id);
    }

}

