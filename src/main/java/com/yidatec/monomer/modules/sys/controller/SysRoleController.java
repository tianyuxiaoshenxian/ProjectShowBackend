package com.yidatec.monomer.modules.sys.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yidatec.monomer.common.api.CommonPage;
import com.yidatec.monomer.common.api.CommonResult;
import com.yidatec.monomer.modules.sys.dto.SysRoleBindUserParam;
import com.yidatec.monomer.modules.sys.dto.SysRoleEditParam;
import com.yidatec.monomer.modules.sys.dto.SysRoleParam;
import com.yidatec.monomer.modules.sys.entity.SysRole;
import com.yidatec.monomer.modules.sys.service.SysRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static com.yidatec.monomer.common.constant.Const._DEFAULT_PAGE_SIZE;
import static com.yidatec.monomer.common.constant.Const._DEFAULT_PAGE_NUM;

/**
 * 后台角色管理
 * @author xudk
 * @since 2022-05-24
 */
@RestController
@Api(tags = "SysRoleController", description = "角色管理")
@RequestMapping("/sys/role")
public class SysRoleController {

    @Autowired
    private SysRoleService sysRoleService;

    @ApiOperation(value = "查询角色列表")
    @GetMapping(value = "/list")
    public CommonResult<CommonPage<SysRole>> list(@RequestParam(value = "keyWord", required = false) String keyWord,
                                                  @RequestParam(value = "pageSize", defaultValue = _DEFAULT_PAGE_SIZE) Integer pageSize,
                                                  @RequestParam(value = "pageNum", defaultValue = _DEFAULT_PAGE_NUM) Integer pageNum) {
        Page<SysRole> userList = sysRoleService.list(keyWord, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(userList));
    }

    @ApiOperation(value = "添加角色")
    @PostMapping(value = "/add")
    public CommonResult<SysRole> add(@Validated @RequestBody SysRoleParam sysRoleParam) {
        SysRole role = sysRoleService.add(sysRoleParam);
        if (null == role) {
            return CommonResult.failed();
        }
        return CommonResult.success(role);
    }

    @ApiOperation(value = "修改角色")
    @PostMapping(value = "/edit")
    public CommonResult<SysRole> edit(@Validated @RequestBody SysRoleEditParam sysRoleEditParam){
        SysRole user = sysRoleService.modify(sysRoleEditParam);
        if (null == user) {
            return CommonResult.failed();
        }
        return CommonResult.success(user);
    }

    @ApiOperation(value = "删除角色")
    @PostMapping(value = "/delete/{id}")
    public CommonResult delete(@PathVariable Long id) {
        boolean result = sysRoleService.delete(id);
        if (result) {
            return CommonResult.success(null);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation(value = "角色绑定用户")
    @PostMapping(value = "/roleBindUsers")
    public CommonResult roleBindUsers(@RequestBody SysRoleBindUserParam sysRoleBindUserParam){
        if(!sysRoleService.roleBindUsers(sysRoleBindUserParam)){
            return CommonResult.failed();
        }
        return CommonResult.success(null);
    }


}
