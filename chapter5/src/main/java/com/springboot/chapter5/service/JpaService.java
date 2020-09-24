package com.springboot.chapter5.service;

import com.springboot.chapter5.enumeration.FoodTypeEnum;
import com.springboot.chapter5.pojo.Food;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @Program: demo
 * @Description:
 * @Author: YiMing
 * @Created: 2020/07/05 14:30
 */
public interface JpaService {

    Food getFood(Long id);

    Food insertFood(Food food);

    void deleteFood(Long id);

    Food updateFood(Food food);

    List<Food> findFoods(String foodName, FoodTypeEnum foodType);

    List<Food> findFoods(String foodName, Integer foodTypeCode);

    List<Food> findFoodsBySort(String foodName, Integer foodTypeCode, String sortField);

    Page<Food> findFoodsByPage(String foodName, Integer foodTypeCode, String sortField, Integer page, Integer size);

    List<Food> queryFoodsByFoodNameLikeAndFoodType(String foodName, Integer foodTypeCode);

    List<Food> queryFoods(String foodName, Integer foodTypeCode);
}
