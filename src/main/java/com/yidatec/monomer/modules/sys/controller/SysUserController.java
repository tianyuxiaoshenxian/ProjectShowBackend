package com.yidatec.monomer.modules.sys.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yidatec.monomer.common.api.CommonPage;
import com.yidatec.monomer.common.api.CommonResult;
import com.yidatec.monomer.modules.sys.dto.SysUserEditParam;
import com.yidatec.monomer.modules.sys.dto.SysUserEditPasswordParam;
import com.yidatec.monomer.modules.sys.dto.SysUserLoginParam;
import com.yidatec.monomer.modules.sys.dto.SysUserParam;
import com.yidatec.monomer.modules.sys.entity.SysUser;
import com.yidatec.monomer.modules.sys.service.SysUserCustomerService;
import com.yidatec.monomer.modules.sys.service.SysUserService;
import com.yidatec.monomer.modules.sys.vo.SysUserRoleVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

import static com.yidatec.monomer.common.constant.Const._DEFAULT_PAGE_NUM;
import static com.yidatec.monomer.common.constant.Const._DEFAULT_PAGE_SIZE;

/**
 * 后台用户管理
 *
 * @author xudk
 * @since 2022-05-24
 */
@RestController
@Api(tags = "SysUserController", description = "用户管理")
@RequestMapping("/sys/user")
public class SysUserController {
    @Value("${jwt.tokenHeader}")
    private String tokenHeader;
    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SysUserCustomerService sysUserCustomerService;

    @ApiOperation(value = "登录以后返回token")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult login(@Validated @RequestBody SysUserLoginParam sysUserLoginParam) {
        String token = sysUserService.login(sysUserLoginParam.getUsername(), sysUserLoginParam.getPassword());
        if (token == null) {
            return CommonResult.validateFailed("用户名或密码错误");
        }
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", tokenHead);
        tokenMap.put("userName", sysUserLoginParam.getUsername());
        return CommonResult.success(tokenMap);
    }

    @ApiOperation(value = "查询用户列表")
    @GetMapping(value = "/list")
    public CommonResult<CommonPage<SysUser>> list(@RequestParam(value = "realName", required = false) String realName,
                                                  @RequestParam(value = "username", required = false) String username,
                                                  @RequestParam(value = "email", required = false) String email,
                                                  @RequestParam(value = "mobile", required = false) String mobile,
                                                  @RequestParam(value = "sex", required = false) Integer sex,
                                                  @RequestParam(value = "status", required = false) Integer status,
                                                  @RequestParam(value = "pageSize", defaultValue = _DEFAULT_PAGE_SIZE) Integer pageSize,
                                                  @RequestParam(value = "pageNum", defaultValue = _DEFAULT_PAGE_NUM) Integer pageNum) {
        Page<SysUser> userList = sysUserService.list(realName, username, email, mobile, sex, status, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(userList));
    }

    @ApiOperation(value = "根据指定角色查询用户列表")
    @GetMapping(value = "/listByRole")
    public CommonResult<CommonPage<SysUserRoleVo>> listByRole(@RequestParam(value = "role") String role,
                                                              @RequestParam(value = "username",required = false) String username,
                                                              @RequestParam(value = "realName",required = false) String realName,
                                                              @RequestParam(value = "email",required = false) String email,
                                                              @RequestParam(value = "mobile",required = false) String mobile,
                                                              @RequestParam(value = "pageSize", defaultValue = _DEFAULT_PAGE_SIZE) Integer pageSize,
                                                              @RequestParam(value = "pageNum", defaultValue = _DEFAULT_PAGE_NUM) Integer pageNum) {
        Page<SysUserRoleVo> userList = sysUserCustomerService.listByRole(role,username,realName,email,mobile, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(userList));
    }

    @ApiOperation(value = "查询用户详细信息")
    @GetMapping(value = "/detail")
    public CommonResult<SysUser> detail(@RequestParam(value = "id") String id) {
        return CommonResult.success(sysUserService.getUserDetail(id));
    }

    @ApiOperation(value = "添加用户")
    @PostMapping(value = "/add")
    public CommonResult<SysUser> add(@Validated @RequestBody SysUserParam sysUserParam) {
        SysUser user = sysUserService.add(sysUserParam);
        if (null == user) {
            return CommonResult.failed();
        }
        return CommonResult.success(user);
    }

    @ApiOperation(value = "修改用户")
    @PostMapping(value = "/edit")
    public CommonResult<SysUser> edit(@Validated @RequestBody SysUserEditParam sysUserEditParam) {
        SysUser user = sysUserService.modify(sysUserEditParam);
        if (null == user) {
            return CommonResult.failed();
        }
        return CommonResult.success(user);
    }

    @ApiOperation(value = "删除用户")
    @PostMapping(value = "/delete/{id}")
    public CommonResult delete(@PathVariable Long id) {
        boolean result = sysUserService.removeById(id);
        if (result) {
            return CommonResult.success(null);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation(value = "修改密码")
    @PostMapping(value = "/editPassword")
    public CommonResult<SysUser> editPassword(@Validated @RequestBody SysUserEditPasswordParam sysUserEditPasswordParam) {
        Boolean result = sysUserService.editPassword(sysUserEditPasswordParam.getUsername(), sysUserEditPasswordParam.getPassword());
        if (!result) {
            return CommonResult.failed();
        }
        return CommonResult.success(null);
    }
}
