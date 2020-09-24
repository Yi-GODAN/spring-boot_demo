package com.springboot.chapter5.service;

import com.springboot.chapter5.enumeration.FoodTypeEnum;
import com.springboot.chapter5.pojo.Food;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Program: demo
 * @Description:
 * @Author: YiMing
 * @Created: 2020/07/09 14:47
 */
public interface MyBatisService {
    public Food getFood(Long id);

    public int deleteFood(Long id);

    public int updateFood(Food food);

    public int insertFood(Food food);

    public List<Food> findFoods(String foodName, FoodTypeEnum foodType);
}
