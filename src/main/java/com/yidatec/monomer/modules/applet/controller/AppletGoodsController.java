package com.yidatec.monomer.modules.applet.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yidatec.monomer.common.api.CommonPage;
import com.yidatec.monomer.common.api.CommonResult;
import com.yidatec.monomer.modules.applet.dto.AppletGoodsParam;
import com.yidatec.monomer.modules.applet.entity.AppletGoods;
import com.yidatec.monomer.modules.applet.service.AppletGoodsService;
import com.yidatec.monomer.modules.applet.vo.AppletIGoodsVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static com.yidatec.monomer.common.constant.Const._DEFAULT_PAGE_NUM;
import static com.yidatec.monomer.common.constant.Const._DEFAULT_PAGE_SIZE;

/**
 * <p>
 * 商品表 前端控制器
 * </p>
 *
 * @author yidatec
 * @since 2022-08-08
 */
@RestController
@Api(tags = "AppletGoodsController", description = "商品管理")
@RequestMapping("/applet/appletGoods")
public class AppletGoodsController {

    @Autowired
    private AppletGoodsService appletGoodsService;

    @ApiOperation(value = "查询商品")
    @GetMapping(value = "/list")
    public CommonResult<CommonPage<AppletIGoodsVo>> list(
            @RequestParam(value = "goodsName", required = false) String goodsName,
            @RequestParam(value = "goodsTypeId", required = false) String goodsTypeId,
            @RequestParam(value = "status", required = false) Integer status,
            @RequestParam(value = "pageSize", defaultValue = _DEFAULT_PAGE_SIZE) Integer pageSize,
            @RequestParam(value = "pageNum", defaultValue = _DEFAULT_PAGE_NUM) Integer pageNum) {
        Page<AppletIGoodsVo> appletGoodsPage = appletGoodsService.list(goodsName,goodsTypeId,status,pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(appletGoodsPage));
    }

    @ApiOperation(value = "添加商品")
    @PostMapping(value = "/addGoods")
    public CommonResult<AppletGoods> addGoods(@Validated @RequestBody AppletGoodsParam appletGoodsParam) {
        AppletGoods appletGoods = appletGoodsService.addGoods(appletGoodsParam);
        if (null == appletGoods) {
            return CommonResult.failed();
        }
        return CommonResult.success(appletGoods);
    }

    @ApiOperation(value = "修改商品")
    @PostMapping(value = "/updateGoods")
    public CommonResult<AppletGoods> updateGoods(@Validated @RequestBody AppletGoodsParam appletGoodsParam) {
        AppletGoods appletGoods = appletGoodsService.updateGoods(appletGoodsParam);
        if (null == appletGoods) {
            return CommonResult.failed();
        }
        return CommonResult.success(appletGoods);
    }

    @ApiOperation(value = "删除商品")
    @PostMapping(value = "/delete/{id}")
    public CommonResult delete(@PathVariable String id) {
        boolean result = appletGoodsService.removeById(id);
        if (result) {
            return CommonResult.success(null);
        } else {
            return CommonResult.failed();
        }
    }
}

