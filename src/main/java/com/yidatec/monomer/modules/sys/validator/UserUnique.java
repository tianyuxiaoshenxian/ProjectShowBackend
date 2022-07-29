package com.yidatec.monomer.modules.sys.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author xudk
 * @since 2022-06-02
 */
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = UserUniqueValidator.class)
public @interface UserUnique {
    String message() default "用户账号重复";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
