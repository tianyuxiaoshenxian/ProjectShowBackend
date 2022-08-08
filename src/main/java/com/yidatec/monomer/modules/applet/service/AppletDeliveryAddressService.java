package com.yidatec.monomer.modules.applet.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yidatec.monomer.modules.applet.dto.AppletDeliveryAddressParam;
import com.yidatec.monomer.modules.applet.dto.AppletUserParam;
import com.yidatec.monomer.modules.applet.entity.AppletDeliveryAddress;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yidatec.monomer.modules.applet.entity.AppletUser;

/**
 * <p>
 * 收货地址 服务类
 * </p>
 *
 * @author yidatec
 * @since 2022-08-08
 */
public interface AppletDeliveryAddressService extends IService<AppletDeliveryAddress> {

    Page<AppletDeliveryAddress> list(String username, String realName, String telephone, Integer pageSize, Integer pageNum);

    AppletDeliveryAddress addAddress(AppletDeliveryAddressParam appletDeliveryAddressParam);

    AppletDeliveryAddress updateAddress(AppletDeliveryAddressParam appletDeliveryAddressParam);

}
