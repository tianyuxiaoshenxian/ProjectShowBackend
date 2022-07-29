package com.yidatec.monomer.config;

import com.yidatec.monomer.modules.sys.entity.SysMenu;
import com.yidatec.monomer.modules.sys.service.SysMenuService;
import com.yidatec.monomer.modules.sys.service.SysUserService;
import com.yidatec.monomer.security.component.DynamicSecurityService;
import com.yidatec.monomer.security.config.SecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 模块相关配置
 * Created by yidatec on 2019/11/9.
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MySecurityConfig extends SecurityConfig {

    @Autowired
    //private UmsAdminService adminService;
    private SysUserService sysUserService;
    @Autowired
    //private UmsResourceService resourceService;
    private SysMenuService resourceService;

    @Bean
    public UserDetailsService userDetailsService() {
        //获取登录用户信息
        return username -> sysUserService.loadUserByUsername(username);
    }

    @Bean
    public DynamicSecurityService dynamicSecurityService() {
        return new DynamicSecurityService() {
            @Override
            public Map<String, ConfigAttribute> loadDataSource() {
                Map<String, ConfigAttribute> map = new ConcurrentHashMap<>();
                List<SysMenu> resourceList = resourceService.list();
                for (SysMenu resource : resourceList) {
                    map.put(resource.getUrl(), new org.springframework.security.access.SecurityConfig(resource.getId() + ":" + resource.getName()));
                }
                return map;
            }
        };
    }
}
