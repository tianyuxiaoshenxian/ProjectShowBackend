package com.yidatec.monomer.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
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
}
