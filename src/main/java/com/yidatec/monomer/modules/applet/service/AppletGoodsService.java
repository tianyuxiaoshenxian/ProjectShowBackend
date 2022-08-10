package com.yidatec.monomer.modules.applet.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yidatec.monomer.modules.applet.dto.AppletGoodsParam;
import com.yidatec.monomer.modules.applet.entity.AppletGoods;
import com.yidatec.monomer.modules.applet.vo.AppletIGoodsVo;

/**
 * <p>
 * 商品表 服务类
 * </p>
 *
 * @author yidatec
 * @since 2022-08-08
 */
public interface AppletGoodsService extends IService<AppletGoods> {

    Page<AppletIGoodsVo> list(String goodsName, String goodsTypeId, Integer status, Integer pageSize, Integer pageNum);

    AppletGoods addGoods(AppletGoodsParam appletGoodsParam);

    AppletGoods updateGoods(AppletGoodsParam appletGoodsParam);

}
