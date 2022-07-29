package com.yidatec.monomer.modules.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yidatec.monomer.modules.sys.entity.SysMenu;
import com.yidatec.monomer.modules.sys.vo.SysMenuTree;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 系统菜单 Mapper 接口
 * </p>
 *
 * @author xudk
 * @since 2022-05-24
 */
public interface SysMenuMapper extends BaseMapper<SysMenu> {

    List<SysMenuTree> getMenus();

    List<SysMenuTree> getRoleMenuList(@Param("userName") String userName);

    List<Long> getRoleCheckedMenuList(@Param("roleId") String roleId);
}
