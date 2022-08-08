package com.yidatec.monomer.modules.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yidatec.monomer.modules.sys.mapper.SysUserRoleVoMapper;
import com.yidatec.monomer.modules.sys.service.SysUserCustomerService;
import com.yidatec.monomer.modules.sys.vo.SysUserRoleVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 后台管理员管理Service实现类
 *
 * @author xudk
 * @since 2022-05-24
 */
@Service
public class SysUserCustomerServiceImpl extends ServiceImpl<SysUserRoleVoMapper, SysUserRoleVo> implements SysUserCustomerService {

    @Resource
    private SysUserRoleVoMapper sysUserRoleVoMapper;
    @Override
  public Page<SysUserRoleVo> listByRole(String role, String username, String realName, String email, String mobile, Integer pageSize, Integer pageNum) {
    Page<SysUserRoleVo> page = new Page<>(pageNum, pageSize);
    LambdaQueryWrapper<SysUserRoleVo> wrapper = new LambdaQueryWrapper<>();
    wrapper.eq(StringUtils.isNotEmpty(username), SysUserRoleVo::getUsername, username)
        .eq(StringUtils.isNotEmpty(realName), SysUserRoleVo::getRealName, realName)
        .eq(StringUtils.isNotEmpty(email), SysUserRoleVo::getEmail, email)
        .eq(StringUtils.isNotEmpty(mobile), SysUserRoleVo::getMobile, mobile);
    //return sysUserRoleVoMapper.findByPage(page,wrapper);
    return sysUserRoleVoMapper.findByPage(page, role, wrapper);
  }
    
}
