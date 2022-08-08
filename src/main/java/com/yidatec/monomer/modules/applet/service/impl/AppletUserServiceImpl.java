package com.yidatec.monomer.modules.applet.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yidatec.monomer.modules.applet.dto.AppletIntegralParam;
import com.yidatec.monomer.modules.applet.dto.AppletUserParam;
import com.yidatec.monomer.modules.applet.dto.SiteEditParam;
import com.yidatec.monomer.modules.applet.dto.SiteParam;
import com.yidatec.monomer.modules.applet.entity.AppletIntegral;
import com.yidatec.monomer.modules.applet.entity.AppletUser;
import com.yidatec.monomer.modules.applet.entity.AppletUserSite;
import com.yidatec.monomer.modules.applet.entity.Site;
import com.yidatec.monomer.modules.applet.mapper.AppletUserMapper;
import com.yidatec.monomer.modules.applet.service.AppletIntegralService;
import com.yidatec.monomer.modules.applet.service.AppletUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yidatec.monomer.modules.applet.service.AppletUserSiteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Autowired
    private AppletIntegralService appletIntegralService;

    @Autowired
    private AppletUserSiteService appletUserSiteService;

    private final int DEL = 0;
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
    @Transactional(rollbackFor = Exception.class)
    public AppletUser register(AppletUserParam appletUserParam) {
        AppletUser appletUser = new AppletUser();
        BeanUtils.copyProperties(appletUserParam, appletUser);
        if (!save(appletUser)) {
            LOGGER.error("注册会员失败！");
            return null;
        }
        AppletUserSite appletUserSite = new AppletUserSite();
        appletUserSite.setUserId(appletUser.getId());
        appletUserSite.setSiteId(appletUserParam.getSiteId());
        appletUserSiteService.save(appletUserSite);
        return appletUser;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public AppletUser editAppletUser(AppletUserParam appletUserParam) {
        AppletUser appletUser = new AppletUser();
        BeanUtils.copyProperties(appletUserParam, appletUser);
        if (!updateById(appletUser)) {
            LOGGER.error("更新会员信息失败！");
            return null;
        }
        QueryWrapper<AppletUserSite> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(AppletUserSite::getUserId,appletUserParam.getId())
                .eq(AppletUserSite::getDel,DEL);
        AppletUserSite appletUserSite = appletUserSiteService.list(wrapper).get(0);
        appletUserSite.setSiteId(appletUserParam.getSiteId());
        appletUserSiteService.updateById(appletUserSite);
        return appletUser;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public AppletUser  plusIntegral(AppletIntegralParam appletIntegralParam){
        AppletUser appletUser = getById(appletIntegralParam.getUserId());
        appletUser.setIntegral(appletIntegralParam.getIntegral()+appletUser.getIntegral());
        if (!updateById(appletUser)) {
            LOGGER.error("积分失败！");
            return null;
        }
        AppletIntegral appletIntegral = new AppletIntegral();
        BeanUtils.copyProperties(appletIntegralParam,appletIntegral);
        appletIntegralService.save(appletIntegral);
        return appletUser;
    }
    @Override
    @Transactional(rollbackFor = Exception.class)
    public AppletUser payIntegral(AppletIntegralParam appletIntegralParam){
        AppletUser appletUser = getById(appletIntegralParam.getUserId());
        appletUser.setIntegral(appletUser.getIntegral()-appletIntegralParam.getIntegral());
        if (!updateById(appletUser)) {
            LOGGER.error("积分失败！");
            return null;
        }
        AppletIntegral appletIntegral = new AppletIntegral();
        BeanUtils.copyProperties(appletIntegralParam,appletIntegral);
        appletIntegralService.save(appletIntegral);
        return appletUser;
    }


}
