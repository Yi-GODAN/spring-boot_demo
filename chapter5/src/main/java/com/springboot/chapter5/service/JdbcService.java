package com.springboot.chapter5.service;

import com.springboot.chapter5.enumeration.FoodTypeEnum;
import com.springboot.chapter5.pojo.Food;

import java.util.List;

/**
 * @Program: demo
 * @Description:
 * @Author: YiMing
 * @Created: 2020/07/02 23:06
 */
public interface JdbcService {
    public Food getFood(Long id);

    public Food getFood2(Long id);

    public Food getFood3(Long id);

    public int insertFood(Food food);

    public int deleteFood(Long id);

    public int updateFood(Food food);

    public List<Food> findFoods(String foodName, FoodTypeEnum foodType);

    public int updateFood2(Food food);

    public int updateFood3(Food food);

    public int updateFood4(Food food);

    public int updateFood5(Food food);



    }
