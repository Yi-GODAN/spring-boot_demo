package com.springboot.chapter4.intercept;

/**
 * @Program: demo
 * @Description:
 * @Author: YiMing
 * @Created: 2020/06/28 19:10
 */
public interface DinnerInterceptor {
    // 事前方法
    public void beforeDinner();
    // 事后异常
    public void afterThrowing();
    // 事后方法
    public void afterDinner();
    // 事后方法
    public void after();
}
