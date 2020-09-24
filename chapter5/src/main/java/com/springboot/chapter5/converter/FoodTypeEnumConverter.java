package com.springboot.chapter5.converter;

import com.springboot.chapter5.enumeration.FoodTypeEnum;

import javax.persistence.AttributeConverter;

/**
 * @Program: demo
 * @Description:
 * @Author: YiMing
 * @Created: 2020/07/05 14:12
 */
public class FoodTypeEnumConverter implements AttributeConverter<FoodTypeEnum, Integer> {
    @Override
    public Integer convertToDatabaseColumn(FoodTypeEnum foodType) {
        return foodType.getCode();
    }

    @Override
    public FoodTypeEnum convertToEntityAttribute(Integer foodTypeCode) {
        return FoodTypeEnum.getFoodTypeEnumByCode(foodTypeCode);
    }
}
