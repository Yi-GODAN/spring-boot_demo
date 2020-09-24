package com.springboot.chapter5.controller;

import com.springboot.chapter5.enumeration.FoodTypeEnum;
import com.springboot.chapter5.pojo.Food;
import com.springboot.chapter5.service.MyBatisService;
import com.springboot.chapter5.vo.FoodVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Program: demo
 * @Description:
 * @Author: YiMing
 * @Created: 2020/07/09 14:46
 */
@Controller
@RequestMapping("/mybatis")
public class MyBatisController {

    @Autowired
    private MyBatisService myBatisService = null;

    @RequestMapping("/food/get")
    @ResponseBody
    public FoodVo getFood(Long id) {
        Food food = this.myBatisService.getFood(id);
        return this.changeToVo(food);
    }

    @RequestMapping("/food/delete")
    @ResponseBody
    public Map<String, Object> deleteFood(Long id) {
        int result = this.myBatisService.deleteFood(id);
        boolean success = result > 0;
        String msg = success ? "删除成功" : "删除失败";
        return this.resultMap(success, msg);
    }

    @RequestMapping("/food/update")
    @ResponseBody
    public Map<String, Object> updateFood(Long id, String foodName, Integer foodTypeCode, String note) {
        Food food = new Food();
        food.setFoodName(foodName);
        if (foodTypeCode != null) {
            food.setFoodType(FoodTypeEnum.getFoodTypeEnumByCode(foodTypeCode));
        }
        food.setNote(note);
        food.setId(id);
        int result = this.myBatisService.updateFood(food);
        boolean success = result > 0;
        String msg = success ? "更新成功" : "更新失败";
        return this.resultMap(success, msg);
    }

    @RequestMapping("/food/insert")
    @ResponseBody
    public FoodVo insertFood(String foodName, Integer foodTypeCode, String note) {
        Food food = new Food();
        food.setFoodName(foodName);
        if (foodTypeCode != null) {
            food.setFoodType(FoodTypeEnum.getFoodTypeEnumByCode(foodTypeCode));
        }
        food.setNote(note);
        // 返回food对象的id（主键回填）
        int result = this.myBatisService.insertFood(food);
        if (result > 0) {
            return this.changeToVo(food);
        }
        throw new RuntimeException("插入食品信息失败");
    }

    @RequestMapping("/food/find")
    @ResponseBody
    public List<FoodVo> findFoods(String foodName, FoodTypeEnum foodType) {
        List<Food> foodList = this.myBatisService.findFoods(foodName, foodType);
        return this.changeToVoList(foodList);
    }

    private Map<String, Object> resultMap(Boolean success, String msg) {
        Map<String, Object> result = new HashMap<>();
        result.put("success", success);
        result.put("message", msg);
        return result;
    }

    private FoodVo changeToVo(Food po) {
        if (po == null) {
            return null;
        }
        FoodVo vo = new FoodVo();
        vo.setId(po.getId());
        vo.setFoodName(po.getFoodName());
        vo.setFoodTypeId(po.getFoodType().getCode());
        vo.setFoodTypeName(po.getFoodType().getName());
        vo.setNote(po.getNote());
        return vo;
    }

    private List<FoodVo> changeToVoList(List<Food> poList) {
        if (poList == null || poList.isEmpty()) {
            return null;
        }
        List<FoodVo> voList = new ArrayList<>();
        for (Food po : poList) {
            voList.add(this.changeToVo(po));
        }
        return voList;
    }
}
