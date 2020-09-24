package com.springboot.chapter5.pojo;

import com.springboot.chapter5.converter.FoodTypeEnumConverter;
import com.springboot.chapter5.enumeration.FoodTypeEnum;
import org.apache.ibatis.type.Alias;

import javax.persistence.*;

/**
 * @Program: demo
 * @Description:
 * @Author: YiMing
 * @Created: 2020/07/02 22:58
 */
@Entity(name = "food")  // 声明为实体类
@Table(name = "t_food") // 定义映射的表
@Alias("food")  // 定义MyBatis别名
public class Food {

    @Id // 标明为主键
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 主键策略，递增
    private Long id;

    @Column(name = "food_name") // 定义属性和表的映射关系 food_name 数据库的列名
    private String foodName;

    @Column(name = "food_type") // 定义属性和表的映射关系 food_type 数据库的列名
    @Convert(converter = FoodTypeEnumConverter.class)   // 定义转换器
    private FoodTypeEnum foodType;

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

    public FoodTypeEnum getFoodType() {
        return foodType;
    }

    public void setFoodType(FoodTypeEnum foodType) {
        this.foodType = foodType;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
