package com.springboot.chapter5.controller;

        import com.springboot.chapter5.enumeration.FoodTypeEnum;
        import com.springboot.chapter5.pojo.Food;
        import com.springboot.chapter5.service.JpaService;
        import com.springboot.chapter5.vo.FoodVo;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.data.domain.Page;
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
 * @Created: 2020/07/05 14:47
 */
@Controller
@RequestMapping("/jpa")
public class JpaController {

    @Autowired
    private JpaService jpaService = null;

    @RequestMapping("/food/custom")
    @ResponseBody
    public List<FoodVo> queryFoodsByCustom(String foodName, Integer foodTypeCode) {
        List<Food> foodList = jpaService.queryFoodsByFoodNameLikeAndFoodType(foodName, foodTypeCode);
        return this.changeToVoList(foodList);
    }

    @RequestMapping("/food/custom/name")
    @ResponseBody
    public List<FoodVo> queryFoodsByFoodNameLikeAndFoodType(String foodName, Integer foodTypeCode) {
        String foodNameLike = "%" + foodName + "%";
        List<Food> foodList = jpaService.queryFoodsByFoodNameLikeAndFoodType(foodNameLike, foodTypeCode);
        return this.changeToVoList(foodList);
    }

    @RequestMapping("/food/sort")
    @ResponseBody
    public List<FoodVo> findFoodBySort(String foodName, Integer foodTypeCode, String sortField) {
        List<Food> foodList = this.jpaService.findFoodsBySort(foodName, foodTypeCode, sortField);
        return this.changeToVoList(foodList);
    }

    @RequestMapping("/food/page")
    @ResponseBody
    public Page<Food> findFoodBySort(String foodName, Integer foodTypeCode, String sortField, Integer page,
                                       Integer size) {
        Page<Food> foodList = this.jpaService.findFoodsByPage(foodName, foodTypeCode, sortField, page, size);
        return foodList;
    }

    @RequestMapping("/food/get")
    @ResponseBody
    public FoodVo getFood(Long id) {
        Food food = jpaService.getFood(id);
        return this.changeToVo(food);
    }

    @RequestMapping("/food/insert")
    @ResponseBody
    public FoodVo insertFood(String foodName, Integer foodTypeCode, String note) {
        Food food = new Food();
        food.setFoodName(foodName);
        food.setFoodType(FoodTypeEnum.getFoodTypeEnumByCode(foodTypeCode));
        food.setNote(note);
        food = this.jpaService.insertFood(food);
        return this.changeToVo(food);
    }

    @RequestMapping("/food/delete")
    @ResponseBody
    public Map<String, Object> deleteFood(Long id) {
        Food food = this.jpaService.getFood(id);
        if (food != null) {
            this.jpaService.deleteFood(id);
            return this.resultMap(true, "删除成功【" + id + "】");
        }
        return this.resultMap(false, "删除失败，食品信息【" + id + "】不存在");
    }

    @RequestMapping("/food/update")
    @ResponseBody
    public FoodVo updateFood(Long id, String foodName, Integer foodTypeCode, String note) {
        Food food = new Food();
        food.setFoodName(foodName);
        food.setFoodType(FoodTypeEnum.getFoodTypeEnumByCode(foodTypeCode));
        food.setNote(note);
        food.setId(id);
        food = this.jpaService.updateFood(food);
        return this.changeToVo(food);
    }

    @RequestMapping("/food/find")
    @ResponseBody
    List<FoodVo> findFoods(String foodName, Integer foodTypeCode) {
        FoodTypeEnum foodType = null;
        if (foodTypeCode != null) {
            foodType = FoodTypeEnum.getFoodTypeEnumByCode(foodTypeCode);
        }
        List<Food> foodList = this.jpaService.findFoods(foodName, foodType);
        return this.changeToVoList(foodList);
    }

    @RequestMapping("/food/find2")
    @ResponseBody
    List<FoodVo> findFoods2(String foodName, Integer foodTypeCode) {
        List<Food> foodList = this.jpaService.findFoods(foodName, foodTypeCode);
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
