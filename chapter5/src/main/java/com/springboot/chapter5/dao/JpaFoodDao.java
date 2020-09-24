package com.springboot.chapter5.dao;

import com.springboot.chapter5.enumeration.FoodTypeEnum;
import com.springboot.chapter5.pojo.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Program: demo
 * @Description:
 * @Author: YiMing
 * @Created: 2020/07/05 14:23
 */
@Repository
public interface JpaFoodDao extends JpaRepository<Food, Long> {

    // food 代表一个实体类
    // "?1"，问号代表一个占位，1代表第一个参数。即?1代表参数foodName，?2代表参数foo_type。
    @Query(value = "from food where food_Name like concat('%', ?1, '%') and food_type = ?2")
    public List<Food> findFoods(String foodName, Integer foodTypeCode);

    public Food getFoodById(Long id);

    public int deleteFoodById(Long id);

    // food_name like ? and food_type = ?
    public List<Food> queryFoodsByFoodNameLikeAndFoodType(String foodName, FoodTypeEnum foodType);

    public List<Food> queryFoods(String foodName, Integer foodTypeCode);
}
