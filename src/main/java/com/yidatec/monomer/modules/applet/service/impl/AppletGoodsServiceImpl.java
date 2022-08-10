package com.yidatec.monomer.modules.applet.service.impl;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yidatec.monomer.modules.applet.dto.AppletGoodsParam;
import com.yidatec.monomer.modules.applet.entity.AppletGoods;
import com.yidatec.monomer.modules.applet.mapper.AppletGoodsMapper;
import com.yidatec.monomer.modules.applet.service.AppletGoodsService;
import com.yidatec.monomer.modules.applet.vo.AppletIGoodsVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品表 服务实现类
 * </p>
 *
 * @author yidatec
 * @since 2022-08-08
 */
@Service
public class AppletGoodsServiceImpl extends ServiceImpl<AppletGoodsMapper, AppletGoods> implements AppletGoodsService {
    private static final Logger LOGGER = LoggerFactory.getLogger(AppletGoodsServiceImpl.class);

    @Override
    public Page<AppletIGoodsVo> list(String goodsName, String goodsTypeId, Integer status, Integer pageSize, Integer pageNum) {
        Page<AppletGoods> page = new Page<>(pageNum, pageSize);
        QueryWrapper<AppletGoods> wrapper = new QueryWrapper<>();
        wrapper.like(StrUtil.isNotEmpty(goodsName),"goods_name",goodsName)
                .eq(StrUtil.isNotEmpty(goodsTypeId),"goods_type_id",goodsTypeId)
                .eq(ObjectUtil.isNotEmpty(status),"status",status);
        Page<AppletIGoodsVo> appletIGoodsVoPage = new Page<>(pageNum, pageSize);
        BeanUtils.copyProperties(page(page, wrapper), appletIGoodsVoPage);
        return appletIGoodsVoPage;
    }

    @Override
    public AppletGoods addGoods(AppletGoodsParam appletGoodsParam) {
        AppletGoods appletGoods = new AppletGoods();
        BeanUtils.copyProperties(appletGoodsParam, appletGoods);
        if (!save(appletGoods)) {
            LOGGER.error("添加商品失败！");
            return null;
        }
        return appletGoods;

    }

    @Override
    public AppletGoods updateGoods(AppletGoodsParam appletGoodsParam) {
        AppletGoods appletGoods = new AppletGoods();
        BeanUtils.copyProperties(appletGoodsParam, appletGoods);
        if (!updateById(appletGoods)) {
            LOGGER.error("更新商品失败！");
            return null;
        }
        return appletGoods;
    }
}
