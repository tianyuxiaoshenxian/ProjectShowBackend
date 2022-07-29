package com.yidatec.monomer.modules.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yidatec.monomer.modules.sys.entity.SysUserRole;
import com.yidatec.monomer.modules.sys.mapper.SysUserRoleMapper;
import com.yidatec.monomer.modules.sys.service.SysUserRoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

/**
 * 后台管理员管理Service实现类
 * @author xudk
 * @since 2022-05-24
 */
@Service
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleMapper, SysUserRole> implements SysUserRoleService {
    private static final Logger LOGGER = LoggerFactory.getLogger(SysUserRoleServiceImpl.class);

    /**
     * 获取用户信息
     * @return userName
     */
    private String getUserName(){
        UserDetails user = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return user.getUsername();
    }

}
