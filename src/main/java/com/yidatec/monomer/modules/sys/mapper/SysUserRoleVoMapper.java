package com.yidatec.monomer.modules.sys.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yidatec.monomer.modules.sys.vo.SysUserRoleVo;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 系统角色 Mapper 接口
 * </p>
 *
 * @author xudk
 * @since 2022-05-24
 */
public interface SysUserRoleVoMapper extends BaseMapper<SysUserRoleVo> {
//    Page<SysUserRoleVo> findByPage(Page<SysUserRoleVo> page, String role, @Param(Constants.WRAPPER) Wrapper<SysUserRoleVo> wrapper);

    Page<SysUserRoleVo> findByPage(Page<SysUserRoleVo> page, String role,String username, String realName, String email, String mobile);
}
