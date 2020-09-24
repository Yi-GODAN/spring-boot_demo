package com.springboot.chapter4.service.impl;

import com.springboot.chapter4.service.DinnerService;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @Program: demo
 * @Description:
 * @Author: YiMing
 * @Created: 2020/06/28 09:41
 */
@Service
public class LunchServiceImpl implements DinnerService {
    @Override
    public void have(String describe, Date date) {
        System.out.println("吃午饭ing，吃的是【"+ describe + "】，时间点是【" + date.getTime() + "】");
//        throw new RuntimeException("发生了急事");
    }
}
