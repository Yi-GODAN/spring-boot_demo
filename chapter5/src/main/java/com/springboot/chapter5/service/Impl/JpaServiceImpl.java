package com.springboot.chapter5.service.Impl;

import com.springboot.chapter5.dao.JpaFoodDao;
import com.springboot.chapter5.enumeration.FoodTypeEnum;
import com.springboot.chapter5.pojo.Food;
import com.springboot.chapter5.service.JpaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @Program: demo
 * @Description:
 * @Author: YiMing
 * @Created: 2020/07/05 14:34
 */
@Service
public class JpaServiceImpl implements JpaService {

    @Autowired
    private JpaFoodDao jpaFoodDao = null;

    @Override
    public Food getFood(Long id) {
        return this.jpaFoodDao.getOne(id);
    }

    @Override
    public Food insertFood(Food food) {
        return this.jpaFoodDao.save(food);
    }

    @Override
    public void deleteFood(Long id) {
        this.jpaFoodDao.deleteById(id);
    }

    @Override
    public Food updateFood(Food food) {
        return this.jpaFoodDao.save(food);
    }

    @Override
    public List<Food> findFoods(String foodName, FoodTypeEnum foodType) {
        Food food = new Food();
        if (!StringUtils.isEmpty(foodName)) {
            food.setFoodName(foodName);
        }
        if (foodType != null) {
            food.setFoodType(foodType);
        }
        Example<Food> exam = Example.of(food);
        return this.jpaFoodDao.findAll(exam);
    }

    @Override
    public List<Food> findFoods(String foodName, Integer foodTypeCode) {
        return this.jpaFoodDao.findFoods(foodName, foodTypeCode);
    }

    @Override
    public List<Food> findFoodsBySort(String foodName, Integer foodTypeCode, String sortField) {
        Food food = new Food();
        if (!StringUtils.isEmpty(foodName)) {
            food.setFoodName(foodName);
        }
        if (foodTypeCode != null) {
            FoodTypeEnum foodType = FoodTypeEnum.getFoodTypeEnumByCode(foodTypeCode);
            food.setFoodType(foodType);
        }
        Example<Food> exam = Example.of(food);
        // 默认升序
//        Sort sort = Sort.by(sortField);
        Sort sort = Sort.by(Sort.Direction.DESC, sortField);
        return this.jpaFoodDao.findAll(exam, sort);
    }

    @Override
    public Page<Food> findFoodsByPage(String foodName, Integer foodTypeCode, String sortField, Integer page,
                                      Integer size) {
        Food food = new Food();
        if (!StringUtils.isEmpty(foodName)) {
            food.setFoodName(foodName);
        }
        if (foodTypeCode != null) {
            FoodTypeEnum foodType = FoodTypeEnum.getFoodTypeEnumByCode(foodTypeCode);
            food.setFoodType(foodType);
        }
        Example<Food> exam = Example.of(food);
        Pageable pageable = null;
        if (!StringUtils.isEmpty(sortField)) {
            Sort sort = Sort.by(sortField);
            pageable = PageRequest.of(page, size, sort);
//            pageable = PageRequest.of(page, size, Sort.Direction.DESC, sortField);
        } else {
            pageable = PageRequest.of(page, size);
        }
        return this.jpaFoodDao.findAll(exam, pageable);
    }

    @Override
    public List<Food> queryFoodsByFoodNameLikeAndFoodType(String foodName, Integer foodTypeCode) {
        FoodTypeEnum foodType = FoodTypeEnum.getFoodTypeEnumByCode(foodTypeCode);
        return this.jpaFoodDao.queryFoodsByFoodNameLikeAndFoodType(foodName, foodType);
    }

    @Override
    public List<Food> queryFoods(String foodName, Integer foodTypeCode) {
        return this.jpaFoodDao.queryFoods(foodName, foodTypeCode);
    }
}

