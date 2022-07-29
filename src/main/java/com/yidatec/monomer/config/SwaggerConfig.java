package com.yidatec.monomer.config;

import com.yidatec.monomer.common.config.BaseSwaggerConfig;
import com.yidatec.monomer.common.domain.SwaggerProperties;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger API文档相关配置
 * Created by yidatec on 2018/4/26.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig extends BaseSwaggerConfig {

    @Override
    public SwaggerProperties swaggerProperties() {
        return SwaggerProperties.builder()
                .apiBasePackage("com.yidatec.monomer.modules")
                .title("monomer项目骨架")
                .description("monomer项目骨架相关接口文档")
                .contactName("yidatec")
                .version("1.0")
                .enableSecurity(true)
                .build();
    }
}
