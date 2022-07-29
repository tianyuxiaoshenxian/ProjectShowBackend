package com.yidatec.monomer.modules.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yidatec.monomer.modules.sys.entity.SysDict;
import com.yidatec.monomer.modules.sys.mapper.SysDictMapper;
import com.yidatec.monomer.modules.sys.service.SysDictService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 职位JD内容Service实现类
 *
 * @author xbr
 * @since 2022-05-27
 */
@Service
@CacheConfig(cacheNames = "sys-dict")
public class SysDictServiceImpl extends ServiceImpl<SysDictMapper, SysDict> implements SysDictService {
    private static final Logger LOGGER = LoggerFactory.getLogger(SysDictServiceImpl.class);

    @Override
    public List<SysDict> getDictByQuery(Long type, Long fid) {
        QueryWrapper<SysDict> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(SysDict::getType, type)
                .eq(SysDict::getFid, fid);
        return list(wrapper);
    }

    /**
     * 字典通过type缓存查询
     * @param type 字典类型
     * @return 字典集合
     */
    @Override
    @Cacheable(value = "sys-dict",key = "#type")
    public List<SysDict> getDictByType(Long type) {
        QueryWrapper<SysDict> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(SysDict::getType, type);
        return list(wrapper);
    }


}
