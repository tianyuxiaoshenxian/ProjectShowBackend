package com.yidatec.monomer.modules.sys.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yidatec.monomer.modules.sys.dto.SysRoleBindUserParam;
import com.yidatec.monomer.modules.sys.dto.SysRoleEditParam;
import com.yidatec.monomer.modules.sys.dto.SysRoleParam;
import com.yidatec.monomer.modules.sys.entity.SysRole;

/**
 * 后台管理橘色管理Service
 *
 * @author xudk
 * @since 2022-05-24
 */
public interface SysRoleService extends IService<SysRole> {

    Page<SysRole> list(String keyword, Integer pageSize, Integer pageNum);

    SysRole add(SysRoleParam sysRoleParam);

    SysRole modify(SysRoleEditParam sysRoleEditParam);

    boolean roleBindUsers(SysRoleBindUserParam sysRoleBindUserParam);

    boolean delete(Long id);
}
