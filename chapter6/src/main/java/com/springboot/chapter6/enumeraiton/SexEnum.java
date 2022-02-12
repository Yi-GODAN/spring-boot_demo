package com.springboot.chapter6.enumeraiton;

/**
 * @Program: demo
 * @Description:
 * @Author: YiMing
 * @Created: 2020/07/11 11:24
 */
public enum SexEnum {
    MAN(2, "男"), WOMAN(1, "女");
    private int code;
    private String sex;

    SexEnum(int code, String name) {
        this.code = code;
        this.sex = name;
    }

    public static SexEnum getSexEnumByCode(int code) {
        for (SexEnum sex : SexEnum.values()) {
            if (sex.getCode() == code) {
                return sex;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
