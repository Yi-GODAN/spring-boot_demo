package com.springboot.other.pojo;

import com.springboot.chapter3.pojo.Dog;
import com.springboot.chapter3.pojo.definition.Animal;
import org.springframework.stereotype.Component;

/**
 * @Program: demo
 * @Description:
 * @Author: YiMing
 * @Created: 2020/06/27 19:38
 */
//@Component
public class Squirrel implements Animal {

    @Override
    public void use() {
        System.out.println("松鼠【" + Dog.class.getSimpleName() + "】是用来采集松果的。");
    }
}
