package com.springboot.chapter5.vo;

import com.springboot.chapter5.enumeration.FoodTypeEnum;

/** View Object
 * @Program: demo
 * @Description:
 * @Author: YiMing
 * @Created: 2020/07/02 23:20
 */
public class FoodVo {
    private Long id;
    private String foodName;
    private Integer foodTypeId;
    private String foodTypeName;
    private String note;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public Integer getFoodTypeId() {
        return foodTypeId;
    }

    public void setFoodTypeId(Integer foodTypeId) {
        this.foodTypeId = foodTypeId;
    }

    public String getFoodTypeName() {
        return foodTypeName;
    }

    public void setFoodTypeName(String foodTypeName) {
        this.foodTypeName = foodTypeName;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
