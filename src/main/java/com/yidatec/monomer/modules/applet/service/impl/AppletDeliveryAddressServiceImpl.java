package com.yidatec.monomer.modules.applet.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yidatec.monomer.modules.applet.dto.AppletDeliveryAddressParam;
import com.yidatec.monomer.modules.applet.dto.AppletUserParam;
import com.yidatec.monomer.modules.applet.entity.AppletDeliveryAddress;
import com.yidatec.monomer.modules.applet.entity.AppletUser;
import com.yidatec.monomer.modules.applet.mapper.AppletDeliveryAddressMapper;
import com.yidatec.monomer.modules.applet.service.AppletDeliveryAddressService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 收货地址 服务实现类
 * </p>
 *
 * @author yidatec
 * @since 2022-08-08
 */
@Service
public class AppletDeliveryAddressServiceImpl extends ServiceImpl<AppletDeliveryAddressMapper, AppletDeliveryAddress> implements AppletDeliveryAddressService {
    private static final Logger LOGGER = LoggerFactory.getLogger(AppletDeliveryAddressServiceImpl.class);

    @Override
    public Page<AppletDeliveryAddress> list(String username, String realName, String telephone, Integer pageSize, Integer pageNum) {
        Page<AppletDeliveryAddress> page = new Page<>(pageNum, pageSize);
        QueryWrapper<AppletDeliveryAddress> wrapper = new QueryWrapper<>();
        wrapper.like(StrUtil.isNotEmpty(realName),"real_name",realName)
                .like(StrUtil.isNotEmpty(telephone),"telephone",telephone);
        return page(page, wrapper);
    }

    @Override
    public AppletDeliveryAddress addAddress(AppletDeliveryAddressParam appletDeliveryAddressParam) {
        AppletDeliveryAddress appletDeliveryAddress = new AppletDeliveryAddress();
        BeanUtils.copyProperties(appletDeliveryAddressParam, appletDeliveryAddress);
        if (!save(appletDeliveryAddress)) {
            LOGGER.error("添加收货地址失败！");
            return null;
        }
        return appletDeliveryAddress;
    }

    @Override
    public AppletDeliveryAddress updateAddress(AppletDeliveryAddressParam appletDeliveryAddressParam) {
        AppletDeliveryAddress appletDeliveryAddress = new AppletDeliveryAddress();
        BeanUtils.copyProperties(appletDeliveryAddressParam, appletDeliveryAddress);
        if (!updateById(appletDeliveryAddress)) {
            LOGGER.error("更新收货地址失败！");
            return null;
        }
        return appletDeliveryAddress;
    }
}
