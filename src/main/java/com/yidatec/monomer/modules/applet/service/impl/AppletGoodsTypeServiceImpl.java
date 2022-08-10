package com.yidatec.monomer.modules.applet.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yidatec.monomer.common.api.CommonResult;
import com.yidatec.monomer.modules.applet.dto.AppletGoodsTypeParam;
import com.yidatec.monomer.modules.applet.entity.AppletGoods;
import com.yidatec.monomer.modules.applet.entity.AppletGoodsType;
import com.yidatec.monomer.modules.applet.mapper.AppletGoodsTypeMapper;
import com.yidatec.monomer.modules.applet.service.AppletGoodsService;
import com.yidatec.monomer.modules.applet.service.AppletGoodsTypeService;
import com.yidatec.monomer.modules.applet.vo.AppletIGoodsTypeVo;
import com.yidatec.monomer.modules.sys.entity.SysDict;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品类型表 服务实现类
 * </p>
 *
 * @author yidatec
 * @since 2022-08-08
 */
@Service
public class AppletGoodsTypeServiceImpl extends ServiceImpl<AppletGoodsTypeMapper, AppletGoodsType> implements AppletGoodsTypeService {
    private static final Logger LOGGER = LoggerFactory.getLogger(AppletGoodsTypeServiceImpl.class);

    @Autowired
    private AppletGoodsService appletGoodsService;
    private final int DEL = 0;

    @Override
    public Page<AppletIGoodsTypeVo> list(String typeName, Integer pageSize, Integer pageNum) {
        Page<AppletGoodsType> page = new Page<>(pageNum, pageSize);
        QueryWrapper<AppletGoodsType> wrapper = new QueryWrapper<>();
        wrapper.like(StrUtil.isNotEmpty(typeName), "type_name", typeName)
                .eq("del", DEL);
        Page<AppletIGoodsTypeVo> appletIGoodsTypeVoPage = new Page<>(pageNum, pageSize);
        BeanUtils.copyProperties(page(page, wrapper), appletIGoodsTypeVoPage);
        return appletIGoodsTypeVoPage;
    }

    @Override
    public AppletGoodsType add(AppletGoodsTypeParam appletGoodsTypeParam) {
        AppletGoodsType appletGoodsType = new AppletGoodsType();
        BeanUtils.copyProperties(appletGoodsTypeParam, appletGoodsType);
        if (!save(appletGoodsType)) {
            LOGGER.error("添加商品类型失败！");
            return null;
        }
        return appletGoodsType;
    }

    @Override
    public AppletGoodsType update(AppletGoodsTypeParam appletGoodsTypeParam) {
        AppletGoodsType appletGoodsType = new AppletGoodsType();
        BeanUtils.copyProperties(appletGoodsTypeParam, appletGoodsType);
        if (!updateById(appletGoodsType)) {
            LOGGER.error("更新商品类型失败！");
            return null;
        }
        return appletGoodsType;
    }

    @Override
    public CommonResult delete(String id) {
        LambdaQueryWrapper<AppletGoods> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(AppletGoods::getGoodsTypeId, id).eq(AppletGoods::getDel, DEL);
        if (appletGoodsService.list(wrapper).size()>0) {
            LOGGER.error("商品类型已被使用，不可删除！");
            return CommonResult.failed("商品类型已被使用，不可删除！");
        }
        return CommonResult.success(removeById(id));
    }
}
