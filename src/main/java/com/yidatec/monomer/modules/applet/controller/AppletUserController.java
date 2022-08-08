package com.yidatec.monomer.modules.applet.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yidatec.monomer.common.api.CommonPage;
import com.yidatec.monomer.common.api.CommonResult;
import com.yidatec.monomer.modules.applet.dto.AppletIntegralParam;
import com.yidatec.monomer.modules.applet.dto.AppletUserParam;
import com.yidatec.monomer.modules.applet.entity.AppletUser;
import com.yidatec.monomer.modules.applet.service.AppletUserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static com.yidatec.monomer.common.constant.Const._DEFAULT_PAGE_NUM;
import static com.yidatec.monomer.common.constant.Const._DEFAULT_PAGE_SIZE;

/**
 * <p>
 * 小程序用户 前端控制器
 * </p>
 *
 * @author xbr
 * @since 2022-08-04
 */
@RestController
@RequestMapping("/applet/appletUser")
public class AppletUserController {

    @Autowired
    private AppletUserService appletUserService;

    @ApiOperation(value = "查询会员")
    @GetMapping(value = "/list")
    public CommonResult<CommonPage<AppletUser>> list(
            @RequestParam(value = "username", required = false) String username,
            @RequestParam(value = "realName", required = false) String realName,
            @RequestParam(value = "phoneNumber", required = false) String phoneNumber,
            @RequestParam(value = "idCard", required = false) String idCard,
            @RequestParam(value = "pageSize", defaultValue = _DEFAULT_PAGE_SIZE) Integer pageSize,
            @RequestParam(value = "pageNum", defaultValue = _DEFAULT_PAGE_NUM) Integer pageNum) {
        Page<AppletUser> appletUserPage = appletUserService.list(username, realName, phoneNumber, idCard, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(appletUserPage));
    }

    @ApiOperation(value = "注册会员")
    @PostMapping(value = "/register")
    public CommonResult<AppletUser> register(@Validated @RequestBody AppletUserParam appletUserParam) {
        AppletUser appletUser = appletUserService.register(appletUserParam);
        if (null == appletUser) {
            return CommonResult.failed();
        }
        return CommonResult.success(appletUser);
    }

    @ApiOperation(value = "修改会员信息")
    @PostMapping(value = "/edit")
    public CommonResult<AppletUser> editAppletUser(@Validated @RequestBody AppletUserParam appletUserParam) {
        AppletUser appletUser = appletUserService.editAppletUser(appletUserParam);
        if (null == appletUser) {
            return CommonResult.failed();
        }
        return CommonResult.success(appletUser);
    }

    @ApiOperation(value = "删除会员")
    @PostMapping(value = "/delete/{id}")
    public CommonResult delete(@PathVariable String id) {
        boolean result = appletUserService.removeById(id);
        if (result) {
            return CommonResult.success(null);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation(value = "增加会员积分")
    @PostMapping(value = "/plusIntegral")
    public CommonResult<AppletUser> plusIntegral(@RequestBody AppletIntegralParam appletIntegralParam) {
        AppletUser appletUser = appletUserService.plusIntegral(appletIntegralParam);
        if (null == appletUser) {
            return CommonResult.failed();
        }
        return CommonResult.success(appletUser);
    }
    @ApiOperation(value = "消费会员积分")
    @PostMapping(value = "/payIntegral")
    public CommonResult<AppletUser> payIntegral(@RequestBody AppletIntegralParam appletIntegralParam) {
        AppletUser appletUser = appletUserService.payIntegral(appletIntegralParam);
        if (null == appletUser) {
            return CommonResult.failed();
        }
        return CommonResult.success(appletUser);
    }


}

