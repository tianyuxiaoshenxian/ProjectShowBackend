package com.yidatec.monomer.modules.sys.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yidatec.monomer.common.api.CommonResult;
import com.yidatec.monomer.modules.sys.dto.SysDictParam;
import com.yidatec.monomer.modules.sys.entity.SysDict;

import java.util.List;

/**
 * 字典Service
 *
 * @author xbr
 * @since 2022-05-30
 */
public interface SysDictService extends IService<SysDict> {

    List<SysDict> getDictByQuery(Long type, Long fid);

    List<SysDict> getDictByType(Long type);

    List<SysDict> fidList();

    Page<SysDict> list(String name, Integer type, Integer code, String value, String remark, Integer pageSize, Integer pageNum);

    SysDict addSysDict(SysDictParam sysDictParam);

    SysDict editSysDict(SysDictParam sysDictParam);

    CommonResult delete(Long id);
}
