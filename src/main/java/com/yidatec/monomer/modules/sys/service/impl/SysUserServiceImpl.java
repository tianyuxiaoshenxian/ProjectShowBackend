package com.yidatec.monomer.modules.sys.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.collect.Lists;
import com.yidatec.monomer.common.exception.Asserts;
import com.yidatec.monomer.domain.SysUserDetails;
import com.yidatec.monomer.modules.sys.dto.SysUserEditParam;
import com.yidatec.monomer.modules.sys.dto.SysUserParam;
import com.yidatec.monomer.modules.sys.entity.SysMenu;
import com.yidatec.monomer.modules.sys.entity.SysUser;
import com.yidatec.monomer.modules.sys.enums.UseStatus;
import com.yidatec.monomer.modules.sys.enums.UserDelStatus;
import com.yidatec.monomer.modules.sys.mapper.SysUserMapper;
import com.yidatec.monomer.modules.sys.service.SysUserService;
import com.yidatec.monomer.security.util.JwtTokenUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 后台管理员管理Service实现类
 * @author xudk
 * @since 2022-05-24
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {
    private static final Logger LOGGER = LoggerFactory.getLogger(SysUserServiceImpl.class);
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private PasswordEncoder passwordEncoder;

    //初始密码
    private final String _INIT_PASSWORD = "1";

    @Override
    public Page<SysUser> list(String keyword, Integer pageSize, Integer pageNum) {
        Page<SysUser> page = new Page<>(pageNum,pageSize);
        QueryWrapper<SysUser> wrapper = new QueryWrapper<>();
        LambdaQueryWrapper<SysUser> lambda = wrapper.lambda();
        if(StrUtil.isNotEmpty(keyword)){
            lambda.like(SysUser::getUsername,keyword);
            lambda.or().like(SysUser::getRealName,keyword);
        }
        return page(page,wrapper);
    }

    @Override
    public SysUser getUserDetail(String id) {
        return getById(id);
    }

    @Override
    public String login(String username, String password) {
        String token = null;
        //密码需要客户端加密后传递
        try {
            UserDetails userDetails = loadUserByUsername(username);
            if(!passwordEncoder.matches(password,userDetails.getPassword())){
                Asserts.fail("密码不正确");
            }
            if(!userDetails.isEnabled()){
                Asserts.fail("帐号已被禁用");
            }
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            token = jwtTokenUtil.generateToken(userDetails);
        } catch (AuthenticationException e) {
            LOGGER.warn("登录异常:{}", e.getMessage());
        }
        return token;
    }

    @Override
    public SysUser register(SysUserParam sysUserParam) {
        SysUser sysUser = new SysUser();
        BeanUtils.copyProperties(sysUserParam, sysUser);
        sysUser.setPassword(passwordEncoder.encode(_INIT_PASSWORD));
        sysUser.setStatus(UseStatus.NORMAL.getCode());
        sysUser.setDel(UserDelStatus.NORMAL.getCode());
        if(!save(sysUser)){
            LOGGER.error("创建用户失败！");
            return null ;
        }
        return sysUser;
    }

    @Override
    public SysUser modify(SysUserEditParam sysUserEditParam) {
        SysUser sysUser = new SysUser();
        BeanUtils.copyProperties(sysUserEditParam, sysUser);
        sysUser.setUpdateTime(new Date());
        if(!updateById(sysUser)){
            LOGGER.error("修改用户失败！");
            return null ;
        }
        return sysUser;
    }

    @Override
    public boolean delete(Long id) {
        return removeById(id);
    }

    @Override
    public SysUser getAdminByUsername(String username) {
        QueryWrapper<SysUser> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(SysUser::getUsername,username);
        List<SysUser> adminList = list(wrapper);
        return adminList.get(0);
    }

    @Override
    public UserDetails loadUserByUsername(String username){
        //获取用户信息
        SysUser admin = getAdminByUsername(username);
        if (admin != null) {
            List<SysMenu> resourceList = Lists.newArrayList();
            return new SysUserDetails(admin,resourceList);
        }
        throw new UsernameNotFoundException("用户名或密码错误");
    }

    @Override
    public Boolean userIsExist(String username) {
        QueryWrapper<SysUser> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(SysUser::getUsername,username);
        SysUser user = baseMapper.selectOne(wrapper);
        return null != user;
    }

    @Override
    public Boolean editPassword(String username,String password) {
        LambdaUpdateWrapper<SysUser> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(SysUser::getUsername,username).set(SysUser::getPassword,passwordEncoder.encode(password));
        return update(updateWrapper);
    }

}