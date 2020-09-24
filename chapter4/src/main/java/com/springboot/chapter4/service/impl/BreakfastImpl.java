package com.springboot.chapter4.service.impl;

import com.springboot.chapter4.service.DinnerService;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @Program: demo
 * @Description:
 * @Author: YiMing
 * @Created: 2020/06/28 18:37
 */
@Service
public class BreakfastImpl implements DinnerService {
    @Override
    public void have(String describe, Date date) {
        System.out.println("吃早餐ing，吃的是【"+ describe + "】，时间点是【" + date.getTime() + "】");
    }
}
