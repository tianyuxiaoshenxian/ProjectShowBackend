package com.yidatec.monomer.modules.sys.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yidatec.monomer.modules.sys.dto.SysRoleBindUserParam;
import com.yidatec.monomer.modules.sys.dto.SysRoleEditParam;
import com.yidatec.monomer.modules.sys.dto.SysRoleParam;
import com.yidatec.monomer.modules.sys.entity.SysRole;
import com.yidatec.monomer.modules.sys.entity.SysRoleMenu;
import com.yidatec.monomer.modules.sys.entity.SysUserRole;
import com.yidatec.monomer.modules.sys.mapper.SysRoleMapper;
import com.yidatec.monomer.modules.sys.service.SysRoleMenuService;
import com.yidatec.monomer.modules.sys.service.SysRoleService;
import com.yidatec.monomer.modules.sys.service.SysUserRoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 后台管理员管理Service实现类
 * @author xudk
 * @since 2022-05-24
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {
    private static final Logger LOGGER = LoggerFactory.getLogger(SysRoleServiceImpl.class);

    @Autowired
    private SysUserRoleService sysUserRoleService;

    @Autowired
    private SysRoleMenuService sysRoleMenuService;

    @Override
    public Page<SysRole> list(String keyword, Integer pageSize, Integer pageNum) {
        Page<SysRole> page = new Page<>(pageNum,pageSize);
        QueryWrapper<SysRole> wrapper = new QueryWrapper<>();
        LambdaQueryWrapper<SysRole> lambda = wrapper.lambda();
        if(StrUtil.isNotEmpty(keyword)){
            lambda.like(SysRole::getRoleName,keyword);
            lambda.or().like(SysRole::getRoleCode,keyword);
        }
        return page(page,wrapper);
    }

    @Override
    @Transactional
    public SysRole add(SysRoleParam sysRoleParam) {
        SysRole sysRole = new SysRole();
        BeanUtils.copyProperties(sysRoleParam, sysRole);
        if(save(sysRole)){
            addOrDelMenus(sysRole.getId(),sysRoleParam.getAddMenuIds(),sysRoleParam.getDelMenuIds());
        }
        return sysRole;
    }

    @Override
    @Transactional
    public SysRole modify(SysRoleEditParam sysRoleEditParam) {
        SysRole sysRole = new SysRole();
        BeanUtils.copyProperties(sysRoleEditParam, sysRole);
        if(updateById(sysRole)){
            addOrDelMenus(sysRole.getId(),sysRoleEditParam.getAddMenuIds(),sysRoleEditParam.getDelMenuIds());
        }
        return sysRole;
    }

    @Override
    @Transactional
    public boolean roleBindUsers(SysRoleBindUserParam sysRoleBindUserParam) {
        if(sysRoleBindUserParam.getAddUserList().size() > 0){
            List<SysUserRole> addUserRoles = sysRoleBindUserParam.getAddUserList()
                    .stream().map(item->{
                        SysUserRole sysUserRole = new SysUserRole();
                        sysUserRole.setRoleId(sysRoleBindUserParam.getRoleId());
                        sysUserRole.setUserId(item);
                        return sysUserRole;
                    }).collect(Collectors.toList());
            sysUserRoleService.saveBatch(addUserRoles);
        }
        if(sysRoleBindUserParam.getDelUserList().size() > 0){
            LambdaQueryWrapper<SysUserRole> roleUserWrapper = new LambdaQueryWrapper<>();
            roleUserWrapper.eq(SysUserRole::getRoleId,sysRoleBindUserParam.getRoleId())
                    .in(SysUserRole::getUserId,sysRoleBindUserParam.getDelUserList());
            sysUserRoleService.remove(roleUserWrapper);
        }
        return true;
    }

    /**
     * 角色绑定或者解除绑定菜单
     * @param roleId 角色
     * @param addMenuList 绑定菜单
     * @param delMenuList 解绑菜单
     */
    private void addOrDelMenus(Long roleId,List<Long> addMenuList,List<Long> delMenuList){
        if(addMenuList.size() > 0){
            List<SysRoleMenu> addMenus = addMenuList
                    .stream().map(item->{
                        SysRoleMenu roleMenu = new SysRoleMenu();
                        roleMenu.setRoleId(roleId);
                        roleMenu.setMenuId(item);
                        return roleMenu;
                    }).collect(Collectors.toList());
            sysRoleMenuService.saveBatch(addMenus);
        }
        if(delMenuList.size() > 0){
            LambdaQueryWrapper<SysRoleMenu> roleUserWrapper = new LambdaQueryWrapper<>();
            roleUserWrapper.eq(SysRoleMenu::getRoleId,roleId).in(SysRoleMenu::getMenuId,delMenuList);
            sysRoleMenuService.remove(roleUserWrapper);
        }
    }

}
