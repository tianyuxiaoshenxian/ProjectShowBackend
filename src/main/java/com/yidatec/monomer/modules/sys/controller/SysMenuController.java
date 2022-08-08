package com.yidatec.monomer.modules.sys.controller;

import com.yidatec.monomer.common.api.CommonResult;
import com.yidatec.monomer.modules.sys.service.SysMenuService;
import com.yidatec.monomer.modules.sys.vo.SysMenuTree;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 后台用户菜单管理
 * @author xudk
 * @since 2022-05-24
 */
@RestController
@Api(tags = "SysMenuController", description = "菜单管理")
@RequestMapping("/sys/menu")
public class SysMenuController {

    @Autowired
    private SysMenuService sysMenuService;

    @ApiOperation(value = "查询所有菜单")
    @GetMapping(value = "/list")
    public CommonResult<List<SysMenuTree>> list() {
        return CommonResult.success(sysMenuService.getMenuList());
    }

    @ApiOperation(value = "查询当前人菜单")
    @GetMapping(value = "/getRoleMenuList")
    public CommonResult<List<SysMenuTree>> getRoleMenuList() {
         List<SysMenuTree> roleMenuList = sysMenuService.getRoleMenuList();
        return CommonResult.success(roleMenuList);
    }

    @ApiOperation(value = "查询勾选菜单")
    @GetMapping(value = "/getRoleCheckedMenuList")
    public CommonResult<List<SysMenuTree>> getRoleCheckedMenuList(@RequestParam("roleId") String roleId) {
        return CommonResult.success(sysMenuService.getRoleCheckedMenuList(roleId));
    }

}
