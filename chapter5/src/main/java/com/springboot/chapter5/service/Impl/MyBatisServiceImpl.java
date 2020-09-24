package com.springboot.chapter5.service.Impl;

import com.springboot.chapter5.dao.MyBatisFoodDao;
import com.springboot.chapter5.enumeration.FoodTypeEnum;
import com.springboot.chapter5.pojo.Food;
import com.springboot.chapter5.service.MyBatisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Program: demo
 * @Description:
 * @Author: YiMing
 * @Created: 2020/07/09 14:48
 */
@Service
public class MyBatisServiceImpl implements MyBatisService {

    @Autowired
    private MyBatisFoodDao myBatisFoodDao = null;

    @Override
    public Food getFood(Long id) {
        return myBatisFoodDao.getFood(id);
    }

    @Override
    public int deleteFood(Long id) {
        return myBatisFoodDao.deleteFood(id);
    }

    @Override
    public int updateFood(Food food) {
        return myBatisFoodDao.updateFood(food);
    }

    @Override
    public int insertFood(Food food) {
        return myBatisFoodDao.insertFood(food);
    }

    @Override
    public List<Food> findFoods(String foodName, FoodTypeEnum foodType) {
        return myBatisFoodDao.findFoods(foodName, foodType);
    }
}
