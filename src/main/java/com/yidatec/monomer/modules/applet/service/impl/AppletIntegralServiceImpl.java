package com.yidatec.monomer.modules.applet.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yidatec.monomer.modules.applet.entity.AppletIntegral;
import com.yidatec.monomer.modules.applet.entity.AppletUser;
import com.yidatec.monomer.modules.applet.mapper.AppletIntegralMapper;
import com.yidatec.monomer.modules.applet.service.AppletIntegralService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yidatec.monomer.modules.applet.vo.AppletIntegralVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 小程序会员积分记录 服务实现类
 * </p>
 *
 * @author yidatec
 * @since 2022-08-05
 */
@Service
public class AppletIntegralServiceImpl extends ServiceImpl<AppletIntegralMapper, AppletIntegral> implements AppletIntegralService {
    private static final Logger LOGGER = LoggerFactory.getLogger(AppletIntegralServiceImpl.class);

    @Autowired
    private AppletIntegralMapper appletIntegralMapper;

    @Override
    public Page<AppletIntegralVo> list(String username, String realName, String phoneNumber, String idCard, Integer pageSize, Integer pageNum) {
        Page<AppletIntegralVo> page = new Page<>(pageNum, pageSize);
        return appletIntegralMapper.list(username, realName, phoneNumber, idCard, page);
    }

    @Override
    public AppletIntegral addRecord() {
        AppletIntegral appletIntegral = new AppletIntegral();
        if (!save(appletIntegral)) {
            LOGGER.error("消费记录添加失败！");
        }
        return appletIntegral;
    }
}
