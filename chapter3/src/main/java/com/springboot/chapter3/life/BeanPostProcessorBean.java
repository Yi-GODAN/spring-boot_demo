package com.springboot.chapter3.life;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/**
 * @Program: demo
 * @Description:
 * @Author: YiMing
 * @Created: 2020/06/26 18:56
 */
@Component
public class BeanPostProcessorBean implements BeanPostProcessor {

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("BeanPostProcessor 的 postProcessBeforeInitialization【"+beanName+"】【"+ bean.getClass().getName() +
                "】");
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("BeanPostProcessor 的 postProcessAfterInitialization【"+beanName+"】【"+ bean.getClass().getName() +
                "】");
        return bean;
    }
}
