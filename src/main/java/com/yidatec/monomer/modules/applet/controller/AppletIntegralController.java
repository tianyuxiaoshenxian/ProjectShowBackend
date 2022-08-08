package com.yidatec.monomer.modules.applet.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yidatec.monomer.common.api.CommonPage;
import com.yidatec.monomer.common.api.CommonResult;
import com.yidatec.monomer.modules.applet.entity.AppletIntegral;
import com.yidatec.monomer.modules.applet.entity.AppletUser;
import com.yidatec.monomer.modules.applet.service.AppletIntegralService;
import com.yidatec.monomer.modules.applet.vo.AppletIntegralVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static com.yidatec.monomer.common.constant.Const._DEFAULT_PAGE_NUM;
import static com.yidatec.monomer.common.constant.Const._DEFAULT_PAGE_SIZE;

/**
 * <p>
 * 小程序会员积分记录 前端控制器
 * </p>
 *
 * @author yidatec
 * @since 2022-08-05
 */
@RestController
@Api(tags = "AppletIntegralController", description = "消费记录")
@RequestMapping("/applet/appletIntegral")
public class AppletIntegralController {

    @Autowired
    private AppletIntegralService appletIntegralService;

    @ApiOperation(value = "查询会员积分记录")
    @GetMapping(value = "/list")
    public CommonResult<CommonPage<AppletIntegralVo>> list(
            @RequestParam(value = "username", required = false) String username,
            @RequestParam(value = "realName", required = false) String realName,
            @RequestParam(value = "phoneNumber", required = false) String phoneNumber,
            @RequestParam(value = "idCard", required = false) String idCard,
            @RequestParam(value = "pageSize", defaultValue = _DEFAULT_PAGE_SIZE) Integer pageSize,
            @RequestParam(value = "pageNum", defaultValue = _DEFAULT_PAGE_NUM) Integer pageNum) {
        Page<AppletIntegralVo> appletIntegrals = appletIntegralService.list(username, realName, phoneNumber, idCard, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(appletIntegrals));
    }

}

