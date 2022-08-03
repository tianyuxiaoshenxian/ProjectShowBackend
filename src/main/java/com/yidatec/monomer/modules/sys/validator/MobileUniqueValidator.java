package com.yidatec.monomer.modules.sys.validator;

import com.yidatec.monomer.modules.sys.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author xbr
 * @since 2022-08-02
 */
public class MobileUniqueValidator implements ConstraintValidator<MobileUnique,String> {

    @Autowired
    private SysUserService sysUserService;
    @Override
    public boolean isValid(String mobile,ConstraintValidatorContext constraintValidatorContext) {
        return !sysUserService.mobileIsExist(mobile);
    }
}
