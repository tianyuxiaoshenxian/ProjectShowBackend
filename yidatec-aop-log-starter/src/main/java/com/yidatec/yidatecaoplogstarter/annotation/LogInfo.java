package com.yidatec.yidatecaoplogstarter.annotation;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface LogInfo {
    /**
     * 描述
     * @return 描述
     */
    String description() default "";

    /**
     * 日志动作
     * @return 日志动作
     */
    String logAction();

    /**
     * 日志类型
     * @return 日志类型
     */
    String logType();

}