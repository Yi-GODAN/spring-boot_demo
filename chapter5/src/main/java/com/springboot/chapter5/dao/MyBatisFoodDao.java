package com.springboot.chapter5.dao;

import com.springboot.chapter5.enumeration.FoodTypeEnum;
import com.springboot.chapter5.pojo.Food;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


import java.util.List;


/**
 * @Program: demo
 * @Description:
 * @Author: YiMing
 * @Created: 2020/07/09 13:46
 */
// 标识为MyBatis的Mapper 以下两种皆可
@Mapper
//@Repository
public interface MyBatisFoodDao {
    public Food getFood(Long id);

    public int deleteFood(Long id);

    public int updateFood(Food food);

    public int insertFood(Food food);

    public List<Food> findFoods(@Param("foodName") String foodName, @Param("foodType") FoodTypeEnum foodType);
}
