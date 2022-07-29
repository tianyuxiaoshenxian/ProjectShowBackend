package com.yidatec.monomer.modules.sys.validator;

import com.yidatec.monomer.modules.sys.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author xudk
 * @since 2022-06-02
 */
public class UserUniqueValidator implements ConstraintValidator<UserUnique,String> {

    @Autowired
    private SysUserService sysUserService;
    @Override
    public boolean isValid(String userName, ConstraintValidatorContext constraintValidatorContext) {
        return !sysUserService.userIsExist(userName);
    }
}
