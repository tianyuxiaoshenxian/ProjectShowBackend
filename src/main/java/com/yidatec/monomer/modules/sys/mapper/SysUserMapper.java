package com.yidatec.monomer.modules.sys.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yidatec.monomer.modules.sys.entity.SysUser;
import com.yidatec.monomer.modules.sys.vo.SysUserRoleVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 系统用户 Mapper 接口
 * </p>
 *
 * @author xudk
 * @since 2022-05-24
 */
public interface SysUserMapper extends BaseMapper<SysUser> {
}
