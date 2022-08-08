package com.yidatec.monomer.modules.sys.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yidatec.monomer.modules.sys.vo.SysUserRoleVo;

/**
 * 后台管理员管理Service
 *
 * @author xudk
 * @since 2022-05-24
 */
public interface SysUserCustomerService extends IService<SysUserRoleVo> {
    Page<SysUserRoleVo> listByRole(String role,String username,String realName, String email,String mobile, Integer pageSize, Integer pageNum);
}
