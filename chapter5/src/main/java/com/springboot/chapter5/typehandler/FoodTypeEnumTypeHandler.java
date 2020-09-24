package com.springboot.chapter5.typehandler;

import com.springboot.chapter5.enumeration.FoodTypeEnum;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Program: demo
 * @Description:
 * @Author: YiMing
 * @Created: 2020/07/08 15:07
 */
// 声明JDBC类型
@MappedJdbcTypes(value = JdbcType.INTEGER)
// 声明Java类型
@MappedTypes(value = FoodTypeEnum.class)
public class FoodTypeEnumTypeHandler extends BaseTypeHandler<FoodTypeEnum> {
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, FoodTypeEnum foodType,
                                    JdbcType jdbcType) throws SQLException {
        preparedStatement.setInt(i, foodType.getCode());
    }

    @Override
    public FoodTypeEnum getNullableResult(ResultSet resultSet, String s) throws SQLException {
        int code = resultSet.getInt(s);
        return FoodTypeEnum.getFoodTypeEnumByCode(code);
    }

    @Override
    public FoodTypeEnum getNullableResult(ResultSet resultSet, int i) throws SQLException {
        int code = resultSet.getInt(i);
        return FoodTypeEnum.getFoodTypeEnumByCode(code);
    }

    @Override
    public FoodTypeEnum getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        int code = callableStatement.getInt(i);
        return FoodTypeEnum.getFoodTypeEnumByCode(code);
    }
}
