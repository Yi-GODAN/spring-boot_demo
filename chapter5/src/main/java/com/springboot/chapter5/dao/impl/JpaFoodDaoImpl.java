package com.springboot.chapter5.dao.impl;

import com.springboot.chapter5.pojo.Food;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @Program: demo
 * @Description:
 * @Author: YiMing
 * @Created: 2020/07/05 21:21
 */
@Repository
// JPA接口名 + “Impl”
public class JpaFoodDaoImpl {

    // 通过依赖注入得到JPA的实体管理器
    @PersistenceContext
    private EntityManager em = null;

    // 方法与接口保持一致
    public List<Food> queryFoods(String foodName, Integer foodTypeCode) {
        StringBuilder jpql = new StringBuilder("from food where 1=1");
        if (!StringUtils.isEmpty(foodName)) {
            jpql.append(" and food_name like '%" + foodName + "%'");
        }
        if (foodTypeCode != null) {
            jpql.append(" and food_type = " + foodTypeCode);
        }
        return em.createQuery(jpql.toString(), Food.class).getResultList();
    }
}
