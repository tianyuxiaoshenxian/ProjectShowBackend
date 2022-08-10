package com.yidatec.monomer.modules.applet.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yidatec.monomer.modules.applet.entity.AppletIntegral;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yidatec.monomer.modules.applet.vo.AppletIntegralVo;
import org.apache.ibatis.annotations.Param;
import org.mapstruct.Mapper;

/**
 * <p>
 * 小程序会员积分记录 Mapper 接口
 * </p>
 *
 * @author yidatec
 * @since 2022-08-05
 */
@Mapper
public interface AppletIntegralMapper extends BaseMapper<AppletIntegral> {

    Page<AppletIntegralVo> list(@Param("username") String username,
                                @Param("realName") String realName,
                                @Param("phoneNumber") String phoneNumber,
                                @Param("idCard") String idCard,
                                Page page);

    Page<AppletIntegralVo> personalList(Page page);
}
