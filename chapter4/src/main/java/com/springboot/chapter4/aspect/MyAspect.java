package com.springboot.chapter4.aspect;

import com.springboot.chapter4.validator.BreakfastValidator;
import com.springboot.chapter4.validator.impl.BreakfastValidatorImpl;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Program: demo
 * @Description:
 * @Author: YiMing
 * @Created: 2020/06/24 09:29
 */
//@Aspect
//@Component
public class MyAspect {

    // 引入增强
    @DeclareParents(
            // 指定增强那个类的功能
            value = "com.springboot.chapter4.service.impl.BreakfastImpl+",
            defaultImpl = BreakfastValidatorImpl.class)
    // 声明增强接口
    private BreakfastValidator breakfastValidator;

    // 定义切点，通过切点可以匹配对应的连接点，如果匹配则启用AOP
    @Pointcut("execution(* com.springboot.chapter4.service.impl.*.have(..))")
    public void pointCut() {
    }

    // 前置通知
    @Before("pointCut()")
    public void Before(JoinPoint jp) {
        Object[] args = jp.getArgs();   // 非环绕通知获取参数的方式
        System.out.println("before......前置通知");
    }

    // 后置通知
    @After("pointCut() && args(describe, date)")    // 非环绕通知获取参数的方式其二  1. 先定义正则式
    public void after(JoinPoint jp, String describe, Date date) {   // 修改方法参数
        Object[] args = jp.getArgs();
        System.out.println("after......后置通知");
    }

    // 返回通知
    @AfterReturning("pointCut()")
    public void afterReturning() {
        System.out.println("afterReturning......返回通知");
    }

    // 异常通知
    @AfterThrowing("pointCut()")
    public void afterThrowing() {
        System.out.println("afterThrowing......异常通知");
    }

    // 环绕通知
    @Around("pointCut()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("around......执行环绕通知");
        return pjp.proceed();   // 回调目标对象的原有方法
    }
}
