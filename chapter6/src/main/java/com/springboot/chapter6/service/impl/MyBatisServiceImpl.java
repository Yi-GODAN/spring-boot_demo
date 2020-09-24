package com.springboot.chapter6.service.impl;

import com.springboot.chapter6.dao.MyBatisUserDao;
import com.springboot.chapter6.enumeraiton.SexEnum;
import com.springboot.chapter6.pojo.User;
import com.springboot.chapter6.service.MyBatisService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Program: demo
 * @Description:
 * @Author: YiMing
 * @Created: 2020/07/11 15:58
 */
public class MyBatisServiceImpl implements MyBatisService {

    @Autowired
    MyBatisUserDao myBatisUserDao = null;

    @Override
    public User getUser(Long id) {
        return myBatisUserDao.getUser(id);
    }

    @Override
    public int insertUser(User user) {
        return myBatisUserDao.insertUser(user);
    }

    @Override
    public int deleteUser(Long id) {
        return myBatisUserDao.deleteUser(id);
    }

    @Override
    public int updateUser(User user) {
        return myBatisUserDao.updateUser(user);
    }

    @Override
    public List<User> findUser(String userName, SexEnum sex) {
        return myBatisUserDao.findUser(userName, sex);
    }
}
