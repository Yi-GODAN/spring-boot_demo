package com.springboot.chapter3.pojo;

import com.springboot.chapter3.pojo.definition.Animal;
import com.springboot.chapter3.pojo.definition.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @Program: demo
 * @Description:
 * @Author: YiMing
 * @Created: 2020/06/26 12:17
 */
@Component
public class BusinessPerson implements Person {

    BusinessPerson() {
        System.out.println("BusinessPerson 构造方法被调用....");
    }

    @Autowired
    @Qualifier("dog")
    private Animal animal = null;

    @Override
    public void service() {
        this.animal.use();
    }

    @Override
    public void setAnimal(Animal animal) {
        this.animal = animal;
    }
}
