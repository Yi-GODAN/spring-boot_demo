package com.springboot.chapter6.service;

import com.springboot.chapter6.enumeraiton.SexEnum;
import com.springboot.chapter6.pojo.User;

import java.util.List;

/**
 * @Program: demo
 * @Description:
 * @Author: YiMing
 * @Created: 2020/07/11 11:18
 */
public interface MyBatisService {

    public User getUser(Long id);

    public int insertUser(User user);

    public int deleteUser(Long id);

    public int updateUser(User user);

    public List<User> findUser(String userName, SexEnum sex);
}
