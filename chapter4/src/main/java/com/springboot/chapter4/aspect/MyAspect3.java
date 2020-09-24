package com.springboot.chapter4.aspect;

import org.aspectj.lang.annotation.*;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @Program: demo
 * @Description:
 * @Author: YiMing
 * @Created: 2020/06/29 16:39
 */
@Component
@Aspect
//@Order(3)
public class MyAspect3 implements Ordered {

    @Override
    public int getOrder() {
        return 3;
    }

    // 定义切点，通过切点可以匹配对应的连接点，如果匹配则启用AOP
    @Pointcut("execution(* com.springboot.chapter4.service.impl.LunchServiceImpl.have(..))")
    public void pointCut() {
    }

    @Before("pointCut()")
    public void before() {
        System.out.println("【MyAspect3】的【Before】方法");
    }

    @After("pointCut()")
    public void after() {
        System.out.println("【MyAspect3】的【After】方法");

    }

    @AfterReturning("pointCut()")
    public void afterReturning() {
        System.out.println("【MyAspect3】的【AfterReturning】方法");

    }

    @AfterThrowing("pointCut()")
    public void afterThrowing() {
        System.out.println("【MyAspect3】的【AfterThrowing】方法");

    }
}
