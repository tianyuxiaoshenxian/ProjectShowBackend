package com.yidatec.monomer.modules.applet.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yidatec.monomer.common.api.CommonResult;
import com.yidatec.monomer.modules.applet.dto.AppletGoodsTypeParam;
import com.yidatec.monomer.modules.applet.entity.AppletGoodsType;
import com.yidatec.monomer.modules.applet.vo.AppletIGoodsTypeVo;

/**
 * <p>
 * 商品类型表 服务类
 * </p>
 *
 * @author yidatec
 * @since 2022-08-08
 */
public interface AppletGoodsTypeService extends IService<AppletGoodsType> {

    Page<AppletIGoodsTypeVo> list(String typeName, Integer pageSize, Integer pageNum);

    AppletGoodsType add(AppletGoodsTypeParam appletGoodsTypeParam);

    AppletGoodsType update(AppletGoodsTypeParam appletGoodsTypeParam);

    CommonResult delete(String id);
}
