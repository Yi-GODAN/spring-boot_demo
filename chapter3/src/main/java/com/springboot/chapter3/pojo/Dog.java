package com.springboot.chapter3.pojo;

import com.springboot.chapter3.pojo.definition.Animal;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @Program: demo
 * @Description:
 * @Author: YiMing
 * @Created: 2020/06/26 12:22
 */
@Component
public class Dog implements Animal, BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean,
        DisposableBean {

    @PostConstruct
    public void myInit() {
        System.out.println("【" + Dog.class.getSimpleName() + "】@PostConstruct 自定义初始化方法");
    }

    @PreDestroy
    public void myDestroy() {
        System.out.println("【" + Dog.class.getSimpleName() + "】@PreDestroy 自定义销毁方法");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBean 的 destroy 方法");
    }

    @Override
    public void use() {
        System.out.println("狗【" + Dog.class.getSimpleName() + "】是看门用的。");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("BeanFactoryAware 的 setBeanFactory 方法");
    }

    @Override
    public void setBeanName(String s) {
        System.out.println("BeanNameAware 的 setBeanName 方法");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean 的 afterPropertiesSet 方法");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("ApplicationContextAware 的 setApplicationContext 方法");
    }
}
