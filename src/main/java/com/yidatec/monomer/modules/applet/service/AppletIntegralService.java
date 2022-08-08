package com.yidatec.monomer.modules.applet.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yidatec.monomer.modules.applet.entity.AppletIntegral;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yidatec.monomer.modules.applet.entity.AppletUser;
import com.yidatec.monomer.modules.applet.vo.AppletIntegralVo;

/**
 * <p>
 * 小程序会员积分记录 服务类
 * </p>
 *
 * @author yidatec
 * @since 2022-08-05
 */
public interface AppletIntegralService extends IService<AppletIntegral> {

    Page<AppletIntegralVo> list(String username, String realName, String phoneNumber, String idCard, Integer pageSize, Integer pageNum);

    AppletIntegral addRecord();


}
