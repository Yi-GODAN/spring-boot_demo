package com.springboot.chapter3.pojo;

import com.springboot.chapter3.pojo.definition.Animal;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @Program: demo
 * @Description:
 * @Author: YiMing
 * @Created: 2020/06/26 16:30
 */
@Component
//// 当IoC容器找到多个类型时，优先把该类型注入
//@Primary
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE) // 是否为原型
public class Cat implements Animal {

    @Override
    public void use() {
        System.out.println("猫【" + Dog.class.getSimpleName() + "】是用来抓老鼠的。");
    }


}
