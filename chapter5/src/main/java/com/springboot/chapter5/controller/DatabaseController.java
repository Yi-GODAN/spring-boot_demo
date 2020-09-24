package com.springboot.chapter5.controller;

import com.springboot.chapter5.enumeration.FoodTypeEnum;
import com.springboot.chapter5.pojo.Food;
import com.springboot.chapter5.service.JdbcService;
import com.springboot.chapter5.vo.FoodVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Program: demo
 * @Description:
 * @Author: YiMing
 * @Created: 2020/07/02 21:14
 */
@Controller
@RequestMapping("/db")
public class DatabaseController {

    @Autowired
    private DataSource dataSource = null;

    @RequestMapping("/info")
    @ResponseBody
    public Map<String, Object> info() {
        Map<String, Object> map = new HashMap<>();
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
            DatabaseMetaData metaData = conn.getMetaData();
            map.put("product_name", metaData.getDatabaseProductName());
            map.put("version", metaData.getDatabaseProductVersion());
            map.put("url", metaData.getURL());
            map.put("usr_name", metaData.getUserName());
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return map;
    }

    @Autowired
    private JdbcService jdbcService = null;

    @RequestMapping("/food")
    @ResponseBody
    public FoodVo getFood(Long id) {
        Food food = jdbcService.getFood2(id);
        return this.changeToVo(food);
    }

    @RequestMapping("/food/insert")
    @ResponseBody
    public Map<String, Object> insertFood(String foodName, Integer foodTypeCode, String note) {
        Food food = new Food();
        food.setFoodName(foodName);
        food.setFoodType(FoodTypeEnum.getFoodTypeEnumByCode(foodTypeCode));
        food.setNote(note);
        int result = jdbcService.insertFood(food);
        boolean flag = result > 0;
        String msg = flag ? "插入成功" : "插入失败";
        return this.resultMap(flag, msg);
    }

    @RequestMapping("/food/delete")
    @ResponseBody
    public Map<String, Object> deleteFood(Long id) {
        int result = jdbcService.deleteFood(id);
        boolean flag = result > 0;
        String msg = flag ? "删除成功" : "删除失败";
        return this.resultMap(flag, msg);
    }

    @RequestMapping("/food/update")
    @ResponseBody
    public Map<String, Object> updateFood(Long id, String foodName, Integer foodTypeCode, String note) {
        Food food = new Food();
        food.setFoodName(foodName);
        food.setFoodType(FoodTypeEnum.getFoodTypeEnumByCode(foodTypeCode));
        food.setNote(note);
        food.setId(id);
        int result = jdbcService.updateFood4(food);
        boolean flag = result > 0;
        String msg = flag ? "更新成功" : "更新失败";
        return this.resultMap(flag, msg);
    }

    @RequestMapping("/food/find")
    @ResponseBody
    public List<FoodVo> findFood(String foodName, Integer foodTypeCode) {
        FoodTypeEnum foodType = null;
        if (foodTypeCode != null) {
            FoodTypeEnum.getFoodTypeEnumByCode(foodTypeCode);
        }
        List<Food> foodList = jdbcService.findFoods(foodName, foodType);
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
