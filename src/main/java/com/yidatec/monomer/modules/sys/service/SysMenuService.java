package com.yidatec.monomer.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yidatec.monomer.modules.sys.entity.SysMenu;
import com.yidatec.monomer.modules.sys.vo.SysMenuTree;

import java.util.List;

/**
 * 后台管理菜单管理Service
 * @author xudk
 * @since 2022-05-24
 */
public interface SysMenuService extends IService<SysMenu> {

    List<SysMenuTree> getMenuList();

    List<SysMenuTree> getRoleMenuList();

    List<SysMenuTree> getRoleCheckedMenuList(String roleId);
}
