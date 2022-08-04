package com.yidatec.monomer.modules.applet.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yidatec.monomer.modules.applet.dto.SiteEditParam;
import com.yidatec.monomer.modules.applet.dto.SiteParam;
import com.yidatec.monomer.modules.applet.entity.Site;
import com.yidatec.monomer.modules.applet.mapper.SiteMapper;
import com.yidatec.monomer.modules.applet.service.SiteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 站点表 服务实现类
 * </p>
 *
 * @author xbr
 * @since 2022-08-03
 */
@Service
public class SiteServiceImpl extends ServiceImpl<SiteMapper, Site> implements SiteService {
    private static final Logger LOGGER = LoggerFactory.getLogger(SiteServiceImpl.class);

    @Override
    public Page<Site> list(String province, String city, String district, String hospitalName, Integer pageSize, Integer pageNum) {
        Page<Site> page = new Page<>(pageNum, pageSize);
        QueryWrapper<Site> wrapper = new QueryWrapper<>();
        wrapper.like(StrUtil.isNotEmpty(province), "province", province)
                .like(StrUtil.isNotEmpty(city), "city", city)
                .like(StrUtil.isNotEmpty(district), "district", district)
                .like(StrUtil.isNotEmpty(hospitalName), "hospital_name", hospitalName);
        return page(page, wrapper);
    }

    @Override
    public Site addSite(SiteParam siteParam) {
        Site site = new Site();
        BeanUtils.copyProperties(siteParam, site);
        if (!save(site)) {
            LOGGER.error("创建用户失败！");
            return null;
        }
        return site;
    }

    @Override
    public Site editSite(SiteEditParam siteParam) {
        Site site = new Site();
        BeanUtils.copyProperties(siteParam, site);
        if (!updateById(site)) {
            LOGGER.error("更新用户失败！");
            return null;
        }
        return site;
    }

}
