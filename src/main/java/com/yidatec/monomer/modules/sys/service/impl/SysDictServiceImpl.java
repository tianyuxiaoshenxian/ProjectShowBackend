package com.yidatec.monomer.modules.sys.service.impl;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yidatec.monomer.common.api.CommonResult;
import com.yidatec.monomer.modules.sys.dto.SysDictParam;
import com.yidatec.monomer.modules.sys.entity.*;
import com.yidatec.monomer.modules.sys.mapper.SysDictMapper;
import com.yidatec.monomer.modules.sys.service.SysDictService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
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

    private final int DEL = 0;
    private final Long FID = 0l;//父级ID默认值
    @Override
    public List<SysDict> getDictByQuery(Long type, Long fid) {
        QueryWrapper<SysDict> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(SysDict::getType, type)
                .eq(SysDict::getFid, fid);
        return list(wrapper);
    }

    /**
     * 字典通过type缓存查询
     *
     * @param type 字典类型
     * @return 字典集合
     */
    @Override
    @Cacheable(value = "sys-dict", key = "#type")
    public List<SysDict> getDictByType(Long type) {
        QueryWrapper<SysDict> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(SysDict::getType, type);
        return list(wrapper);
    }

    @Override
    public List<SysDict> fidList() {
        QueryWrapper<SysDict> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(SysDict::getFid, FID)
                .eq(SysDict::getDel, DEL);
        return list(wrapper);
    }

    @Override
    public Page<SysDict> list(String name, Integer type, Integer code, String value, String remark, Integer pageSize, Integer pageNum) {
        Page<SysDict> page = new Page<>(pageNum, pageSize);
        QueryWrapper<SysDict> wrapper = new QueryWrapper<>();
        wrapper.like(StrUtil.isNotEmpty(name), "name", name)
                .like(ObjectUtil.isNotEmpty(type), "type", type)
                .like(ObjectUtil.isNotEmpty(code), "code", code)
                .like(StrUtil.isNotEmpty(value), "value", value)
                .like(StrUtil.isNotEmpty(remark), "remark", remark);
        return page(page, wrapper);
    }

    @Override
    public SysDict addSysDict(SysDictParam sysDictParam) {
        if(sysDictParam.getFid()==null){
            sysDictParam.setFid(FID);
        }
        SysDict sysDict = new SysDict();
        BeanUtils.copyProperties(sysDictParam, sysDict);
        if (!save(sysDict)) {
            LOGGER.error("创建字典失败！");
            return null;
        }
        return sysDict;
    }

    @Override
    public SysDict editSysDict(SysDictParam sysDictParam) {
        SysDict sysDict = new SysDict();
        BeanUtils.copyProperties(sysDictParam, sysDict);
        if (sysDict.getFid()==0){
            LambdaQueryWrapper<SysDict> wrapper = new LambdaQueryWrapper<>();
            wrapper.eq(SysDict::getFid, sysDict.getId()).eq(SysDict::getDel, DEL);
            if (list(wrapper).size()>0) {
                LOGGER.error("字典已被作为父级使用，不可更改！");
                return null;
            }
        }
        if (!updateById(sysDict)) {
            LOGGER.error("更新字典失败！");
            return null;
        }
        return sysDict;
    }

    @Override
    public CommonResult delete(Long id) {
        LambdaQueryWrapper<SysDict> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SysDict::getFid, id).eq(SysDict::getDel, DEL);
        if (list(wrapper).size()>0) {
            LOGGER.error("字典已有子级，不能删除！");
            return CommonResult.failed("字典已有子级，不能删除！");
        }
        return CommonResult.success(removeById(id));
    }


}
