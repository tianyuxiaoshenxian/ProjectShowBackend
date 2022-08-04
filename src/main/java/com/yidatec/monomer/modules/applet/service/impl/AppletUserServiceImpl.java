package com.yidatec.monomer.modules.applet.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yidatec.monomer.modules.applet.dto.AppletUserParam;
import com.yidatec.monomer.modules.applet.dto.SiteEditParam;
import com.yidatec.monomer.modules.applet.dto.SiteParam;
import com.yidatec.monomer.modules.applet.entity.AppletUser;
import com.yidatec.monomer.modules.applet.entity.Site;
import com.yidatec.monomer.modules.applet.mapper.AppletUserMapper;
import com.yidatec.monomer.modules.applet.service.AppletUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 小程序用户 服务实现类
 * </p>
 *
 * @author yidatec
 * @since 2022-08-04
 */
@Service
public class AppletUserServiceImpl extends ServiceImpl<AppletUserMapper, AppletUser> implements AppletUserService {
    private static final Logger LOGGER = LoggerFactory.getLogger(AppletUserServiceImpl.class);

    @Override
    public Page<AppletUser> list(String username, String realName, String phoneNumber, String idCard,Integer pageSize, Integer pageNum) {
        Page<AppletUser> page = new Page<>(pageNum, pageSize);
        QueryWrapper<AppletUser> wrapper = new QueryWrapper<>();
        wrapper.like(StrUtil.isNotEmpty(username), "username", username)
                .like(StrUtil.isNotEmpty(realName),"real_name",realName)
                .like(StrUtil.isNotEmpty(phoneNumber),"phone_number",phoneNumber)
                .like(StrUtil.isNotEmpty(idCard),"id_card",idCard);
        return page(page, wrapper);
    }

    @Override
    public AppletUser register(AppletUserParam appletUserParam) {
        AppletUser appletUser = new AppletUser();
        BeanUtils.copyProperties(appletUserParam, appletUser);
        if (!save(appletUser)) {
            LOGGER.error("注册会员失败！");
            return null;
        }
        return appletUser;
    }

    @Override
    public AppletUser editAppletUser(AppletUserParam appletUserParam) {
        AppletUser appletUser = new AppletUser();
        BeanUtils.copyProperties(appletUserParam, appletUser);
        if (!updateById(appletUser)) {
            LOGGER.error("更新会员信息失败！");
            return null;
        }
        return appletUser;
    }

}
