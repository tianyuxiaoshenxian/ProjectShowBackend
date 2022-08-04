package com.yidatec.monomer.modules.applet.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yidatec.monomer.modules.applet.dto.SiteEditParam;
import com.yidatec.monomer.modules.applet.dto.SiteParam;
import com.yidatec.monomer.modules.applet.entity.Site;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>
 * 站点表 服务类
 * </p>
 *
 * @author xbr
 * @since 2022-08-03
 */
public interface SiteService extends IService<Site> {

    Page<Site> list(String province, String city, String district, String hospitalName,Integer pageSize, Integer pageNum);

    Site addSite(SiteParam siteParam);

    Site editSite(SiteEditParam siteParam);

}
