package com.yidatec.monomer.modules.applet.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yidatec.monomer.common.api.CommonPage;
import com.yidatec.monomer.common.api.CommonResult;
import com.yidatec.monomer.modules.applet.dto.AppletDeliveryAddressParam;
import com.yidatec.monomer.modules.applet.entity.AppletDeliveryAddress;
import com.yidatec.monomer.modules.applet.service.AppletDeliveryAddressService;
import com.yidatec.monomer.modules.applet.vo.AppletDeliveryAddressVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static com.yidatec.monomer.common.constant.Const._DEFAULT_PAGE_NUM;
import static com.yidatec.monomer.common.constant.Const._DEFAULT_PAGE_SIZE;

/**
 * <p>
 * 收货地址 前端控制器
 * </p>
 *
 * @author yidatec
 * @since 2022-08-08
 */
@RestController
@Api(tags = "AppletDeliveryAddressController", description = "收货地址")
@RequestMapping("/applet/appletDeliveryAddress")
public class AppletDeliveryAddressController {

    @Autowired
    private AppletDeliveryAddressService appletDeliveryAddressService;

    @ApiOperation(value = "查询收货地址")
    @GetMapping(value = "/list")
    public CommonResult<CommonPage<AppletDeliveryAddressVo>> list(
            @RequestParam(value = "username", required = false) String username,
            @RequestParam(value = "realName", required = false) String realName,
            @RequestParam(value = "telephone", required = false) String telephone,
            @RequestParam(value = "pageSize", defaultValue = _DEFAULT_PAGE_SIZE) Integer pageSize,
            @RequestParam(value = "pageNum", defaultValue = _DEFAULT_PAGE_NUM) Integer pageNum) {
        Page<AppletDeliveryAddressVo> appletUserPage = appletDeliveryAddressService.list(username, realName, telephone, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(appletUserPage));
    }

    @ApiOperation(value = "添加收货地址")
    @PostMapping(value = "/addAddress")
    public CommonResult<AppletDeliveryAddress> addAddress(@Validated @RequestBody AppletDeliveryAddressParam appletDeliveryAddressParam) {
        AppletDeliveryAddress appletDeliveryAddress = appletDeliveryAddressService.addAddress(appletDeliveryAddressParam);
        if (null == appletDeliveryAddress) {
            return CommonResult.failed();
        }
        return CommonResult.success(appletDeliveryAddress);
    }

    @ApiOperation(value = "修改收货地址")
    @PostMapping(value = "/updateAddress")
    public CommonResult<AppletDeliveryAddress> updateAddress(@Validated @RequestBody AppletDeliveryAddressParam appletDeliveryAddressParam) {
        AppletDeliveryAddress appletDeliveryAddress = appletDeliveryAddressService.updateAddress(appletDeliveryAddressParam);
        if (null == appletDeliveryAddress) {
            return CommonResult.failed();
        }
        return CommonResult.success(appletDeliveryAddress);
    }

    @ApiOperation(value = "删除收货地址")
    @PostMapping(value = "/delete/{id}")
    public CommonResult delete(@PathVariable String id) {
        boolean result = appletDeliveryAddressService.removeById(id);
        if (result) {
            return CommonResult.success(null);
        } else {
            return CommonResult.failed();
        }
    }

}

