package com.springboot.chapter5.enumeration;

/**
 * @Program: demo
 * @Description:
 * @Author: YiMing
 * @Created: 2020/07/02 23:00
 */
public enum FoodTypeEnum {
    COOKED(2, "熟食"), RAW(1, "生食");
    private int code;
    private String name;
    FoodTypeEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public static FoodTypeEnum getFoodTypeEnumByCode(int code) {
        for (FoodTypeEnum foodType : FoodTypeEnum.values()) {
            if (foodType.getCode() == code) {
                return foodType;
            }
        }
        return null;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
