package com.yidatec.monomer.modules.sys.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yidatec.monomer.modules.sys.mapper.SysUserRoleVoMapper;
import com.yidatec.monomer.modules.sys.service.SysUserCustomerService;
import com.yidatec.monomer.modules.sys.vo.SysUserRoleVo;
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
    public Page<SysUserRoleVo> listByRole(String role, Integer pageSize, Integer pageNum) {
        Page<SysUserRoleVo> page = new Page<>(pageNum, pageSize);
        return sysUserRoleVoMapper.findByPage(page, role);
    }
}
