package com.springboot.chapter6.dao;

import com.springboot.chapter6.enumeraiton.SexEnum;
import com.springboot.chapter6.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Program: demo
 * @Description:
 * @Author: YiMing
 * @Created: 2020/07/11 15:49
 */
@Mapper
public interface MyBatisUserDao {

    public User getUser(Long id);

    public int insertUser(User user);

    public int deleteUser(Long id);

    public int updateUser(User user);

    public List<User> findUser(@Param("foodName") String userName, @Param("sex") SexEnum sex);
}
