package com.springboot.chapter4.validator.impl;

import com.springboot.chapter4.validator.BreakfastValidator;
import org.springframework.util.StringUtils;

/**
 * @Program: demo
 * @Description:
 * @Author: YiMing
 * @Created: 2020/06/29 11:05
 */
public class BreakfastValidatorImpl implements BreakfastValidator {

    @Override
    public boolean validate(String describe) {
        return !StringUtils.isEmpty(describe);
    }
}
