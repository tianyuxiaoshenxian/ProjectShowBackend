package com.yidatec.monomer.modules.applet.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yidatec.monomer.modules.applet.dto.AppletIntegralParam;
import com.yidatec.monomer.modules.applet.dto.AppletUserParam;
import com.yidatec.monomer.modules.applet.dto.SiteEditParam;
import com.yidatec.monomer.modules.applet.dto.SiteParam;
import com.yidatec.monomer.modules.applet.entity.AppletUser;
import com.yidatec.monomer.modules.applet.entity.Site;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>
 * 小程序用户 服务类
 * </p>
 *
 * @author yidatec
 * @since 2022-08-04
 */
public interface AppletUserService extends IService<AppletUser> {

    Page<AppletUser> list(String username, String realName, String phoneNumber, String idCard,Integer pageSize, Integer pageNum);

    AppletUser register(AppletUserParam appletUserParam);

    AppletUser editAppletUser(AppletUserParam appletUserParam);

    AppletUser plusIntegral(AppletIntegralParam appletIntegralParam);

    AppletUser payIntegral(AppletIntegralParam appletIntegralParam);
}
