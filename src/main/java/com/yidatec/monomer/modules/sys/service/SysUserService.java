package com.yidatec.monomer.modules.sys.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yidatec.monomer.modules.sys.dto.SysUserEditParam;
import com.yidatec.monomer.modules.sys.dto.SysUserParam;
import com.yidatec.monomer.modules.sys.entity.SysUser;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * 后台管理员管理Service
 * @author xudk
 * @since 2022-05-24
 */
public interface SysUserService extends IService<SysUser> {

    SysUser register(SysUserParam user);

    SysUser modify(SysUserEditParam user);

    boolean delete(Long id);

    Page<SysUser> list(String keyword, Integer pageSize, Integer pageNum);

    SysUser getUserDetail(String id);

    /**
     * 根据用户名获取后台管理员
     */
    SysUser getAdminByUsername(String username);
    /**
     * 登录功能
     * @param username 用户名
     * @param password 密码
     * @return 生成的JWT的token
     */
    String login(String username,String password);
    /**
     * 获取用户信息
     */
    UserDetails loadUserByUsername(String username);

    Boolean userIsExist(String username);

    Boolean editPassword(String username,String password);
}
