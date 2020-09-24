package com.springboot.chapter5.service.Impl;

import com.springboot.chapter5.enumeration.FoodTypeEnum;
import com.springboot.chapter5.pojo.Food;
import com.springboot.chapter5.service.JdbcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ConnectionCallback;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.StatementCallback;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Program: demo
 * @Description:
 * @Author: YiMing
 * @Created: 2020/07/02 23:08
 */
@Service
public class JdbcServiceImpl implements JdbcService {

    @Autowired
    private DataSource dataSource = null;

    @Override
    public Food getFood(Long id) {
        Connection conn = null;
        Food food = null;
        try {
            conn = dataSource.getConnection();
            String sql = "select id, food_name, food_type, note from t_food where id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Long fid = rs.getLong("id");
                String foodName = rs.getString("food_name");
                int foodType = rs.getInt("food_type");
                String note = rs.getString("note");
                food = new Food();
                food.setId(fid);
                food.setFoodName(foodName);
                food.setNote(note);
                food.setFoodType(FoodTypeEnum.getFoodTypeEnumByCode(foodType));
            }
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
        return food;
    }

    @Autowired
    private JdbcTemplate jdbcTemplate = null;

    @Override
    public int insertFood(Food food) {
        String sql = "insert into t_food (food_name, food_type, note) values (?, ?, ?)";
        return jdbcTemplate.update(sql, food.getFoodName(), food.getFoodType().getCode(), food.getNote());
    }

    @Override
    public int deleteFood(Long id) {
        String sql = "delete from t_food where id = ?";
        return jdbcTemplate.update(sql, id);
    }

    @Override
    public int updateFood(Food food) {
        String sql = "update t_food set food_name = ?, food_type = ?, note = ? where id = ?";
        return jdbcTemplate.update(sql, food.getFoodName(), food.getFoodType().getCode(), food.getNote(), food.getId());
    }

    @Override
    public int updateFood2(Food food) {
        String existSql = "select count(*) from t_food where id = ?";
        Integer count = jdbcTemplate.queryForObject(existSql, Integer.class, food.getId());
        if (count == null) {
            return 0;
        }
        String sql = "update t_food set food_name = ?, food_type = ?, note = ? where id = ?";
        return jdbcTemplate.update(sql, food.getFoodName(), food.getFoodType().getCode(), food.getNote(), food.getId());
    }

    @Override
    public int updateFood3(Food food) {

         return jdbcTemplate.execute(new StatementCallback<Integer>() {
            @Override
            public Integer doInStatement(Statement statement) throws SQLException, DataAccessException {
                String existSql = "select count(*) total from t_food where id = " + food.getId();
                ResultSet rs = statement.executeQuery(existSql);
                while (rs.next()) {
                    int count = rs.getInt("total");
                    if (count == 0) {
                        return 0;
                    }
                }
                String sql = "update t_food set food_name = ?, food_type = ?, note = ? where id = ?";
                PreparedStatement ps = statement.getConnection().prepareStatement(sql);
                ps.setString(1, food.getFoodName());
                ps.setInt(2, food.getFoodType().getCode());
                ps.setString(3, food.getNote());
                ps.setLong(4, food.getId());
                return ps.executeUpdate();
            }
        });
    }

    @Override
    public int updateFood4(Food food) {
        ConnectionCallback<Integer> connectionCallback = (connection) -> {
            String existSql = "select count(*) total from t_food where id = " + food.getId();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(existSql);
            while (rs.next()) {
                int count = rs.getInt("total");
                if (count == 0) {
                    return 0;
                }
            }
            String sql = "update t_food set food_name = ?, food_type = ?, note = ? where id = ?";
            PreparedStatement ps = statement.getConnection().prepareStatement(sql);
            ps.setString(1, food.getFoodName());
            ps.setInt(2, food.getFoodType().getCode());
            ps.setString(3, food.getNote());
            ps.setLong(4, food.getId());
            return ps.executeUpdate();
        };
        return jdbcTemplate.execute(connectionCallback);
    }

    @Override
    public int updateFood5(Food food) {

        return jdbcTemplate.execute((Statement statement) -> {
                String existSql = "select count(*) total from t_food where id = " + food.getId();
                ResultSet rs = statement.executeQuery(existSql);
                while (rs.next()) {
                    int count = rs.getInt("total");
                    if (count == 0) {
                        return 0;
                    }
                }
                String sql = "update t_food set food_name = ?, food_type = ?, note = ? where id = ?";
                PreparedStatement ps = statement.getConnection().prepareStatement(sql);
                ps.setString(1, food.getFoodName());
                ps.setInt(2, food.getFoodType().getCode());
                ps.setString(3, food.getNote());
                ps.setLong(4, food.getId());
                return ps.executeUpdate();
        });
    }

    @Override
    public List<Food> findFoods(String foodName, FoodTypeEnum foodType) {
        StringBuilder sql = new StringBuilder("select id, food_name, food_type, note from t_food where 1=1");
        List<Object> argList = new ArrayList<>();
        if (!StringUtils.isEmpty(foodName)) {
            sql.append(" and foo_name like concat('%', ?, '%')");
            argList.add(foodName);
        }
        if (foodType != null) {
            sql.append(" and food_type = ?");
            argList.add(foodType.getCode());
        }
        List<Food> foodList = jdbcTemplate.query(sql.toString(), argList.toArray(), getRowMapper());
        return foodList;
    }

    private RowMapper<Food> getRowMapper() {
        // Lambda 表达式
        return (rs, rowNum) -> {
            Long fid = rs.getLong("id");
            String foodName = rs.getString("food_name");
            int foodType = rs.getInt("food_type");
            String note = rs.getString("note");
            Food food = new Food();
            food.setId(fid);
            food.setFoodName(foodName);
            food.setNote(note);
            food.setFoodType(FoodTypeEnum.getFoodTypeEnumByCode(foodType));
            return food;
        };
    }

    @Override
    public Food getFood2(Long id) {
        String sql = "select id, food_name, food_type, note from t_food where id=?";
/*        RowMapper<Food> rowMapper = new RowMapper<Food>() {
            @Override
            public Food mapRow(ResultSet rs, int i) throws SQLException {
                Long fid = rs.getLong("id");
                String foodName= rs.getString("food_name");
                int foodType = rs.getInt("food_type");
                String note= rs.getString("note");
                Food food = new Food();
                food.setId(fid);
                food.setFoodName(foodName);
                food.setNote(note);
                food.setFoodType(FoodTypeEnum.getFoodTypeEnumByCode(foodType));
                return food;
                Food food=jdbcTemplate.queryForObject(sql,rowMapper,id);
                return food;
            }
        };*/

        Food food = jdbcTemplate.queryForObject(sql, getRowMapper(), id);
        return food;
    }

    @Override
    public Food getFood3(Long id) {
        String sql = "select id, food_name, food_type, note from t_food where id=?";
        // Lambda 表达式
        RowMapper<Food> rowMapper = (rs, rowNum) -> {
            Long fid = rs.getLong("id");
            String foodName = rs.getString("food_name");
            int foodType = rs.getInt("food_type");
            String note = rs.getString("note");
            Food food = new Food();
            food.setId(fid);
            food.setFoodName(foodName);
            food.setNote(note);
            food.setFoodType(FoodTypeEnum.getFoodTypeEnumByCode(foodType));
            return food;
        };
        Food food = jdbcTemplate.queryForObject(sql, rowMapper, id);
        return food;
    }
}
