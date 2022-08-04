package com.yidatec.monomer.modules.applet.controller;



import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yidatec.monomer.common.api.CommonPage;
import com.yidatec.monomer.common.api.CommonResult;
import com.yidatec.monomer.modules.applet.dto.SiteEditParam;
import com.yidatec.monomer.modules.applet.dto.SiteParam;
import com.yidatec.monomer.modules.applet.entity.Site;
import com.yidatec.monomer.modules.applet.service.SiteService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static com.yidatec.monomer.common.constant.Const._DEFAULT_PAGE_NUM;
import static com.yidatec.monomer.common.constant.Const._DEFAULT_PAGE_SIZE;

/**
 * <p>
 * 站点表 前端控制器
 * </p>
 *
 * @author xbr
 * @since 2022-08-03
 */
@RestController
@RequestMapping("/sys/site")
public class SiteController {

    @Autowired
    private SiteService siteService;

    @ApiOperation(value = "查询站点")
    @GetMapping(value = "/list")
    public CommonResult<CommonPage<Site>> list(
            @RequestParam(value = "province",required = false) String province,
            @RequestParam(value = "city",required = false) String city,
            @RequestParam(value = "district",required = false) String district,
            @RequestParam(value = "hospitalName",required = false) String hospitalName,
            @RequestParam(value = "pageSize", defaultValue = _DEFAULT_PAGE_SIZE) Integer pageSize,
            @RequestParam(value = "pageNum", defaultValue = _DEFAULT_PAGE_NUM) Integer pageNum) {
        Page<Site> sitePage = siteService.list(province,city,district,hospitalName,pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(sitePage));
    }

    @ApiOperation(value = "添加站点")
    @PostMapping(value = "/add")
    public CommonResult<Site> addSite(@Validated @RequestBody SiteParam siteParam) {
        Site site = siteService.addSite(siteParam);
        if (null == site) {
            return CommonResult.failed();
        }
        return CommonResult.success(site);
    }

    @ApiOperation(value = "修改站点")
    @PostMapping(value = "/edit")
    public CommonResult<Site> editSite(@Validated @RequestBody SiteEditParam siteParam) {
        Site site = siteService.editSite(siteParam);
        if (null == site) {
            return CommonResult.failed();
        }
        return CommonResult.success(site);
    }

    @ApiOperation(value = "删除站点")
    @PostMapping(value = "/delete/{id}")
    public CommonResult delete(@PathVariable String id) {
        boolean result = siteService.removeById(id);
        if (result) {
            return CommonResult.success(null);
        } else {
            return CommonResult.failed();
        }
    }


}

