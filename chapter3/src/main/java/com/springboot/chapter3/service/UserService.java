package com.springboot.chapter3.service;

import com.springboot.chapter3.pojo.User;
import org.springframework.stereotype.Service;

/**
 * @Program: demo
 * @Description:
 * @Author: YiMing
 * @Created: 2020/06/25 22:59
 */
@Service
public class UserService {

    public void printUser(User user) {
        System.out.println("编号：" + user.getId());
        System.out.println("用户名称：" + user.getUserName());
        System.out.println("备注：" + user.getNote());
    }
}
