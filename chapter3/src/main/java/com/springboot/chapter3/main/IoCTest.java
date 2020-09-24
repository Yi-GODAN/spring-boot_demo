package com.springboot.chapter3.main;

import com.springboot.chapter3.config.AppConfig;
import com.springboot.chapter3.pojo.BusinessPerson;
import com.springboot.chapter3.pojo.Cat;
import com.springboot.chapter3.pojo.User;
import com.springboot.chapter3.pojo.User2;
import com.springboot.chapter3.pojo.definition.Person;
import com.springboot.chapter3.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import org.apache.log4j.Logger;

import javax.sql.DataSource;

/**
 * @Program: demo
 * @Description:
 * @Author: YiMing
 * @Created: 2020/06/25 22:03
 */
public class IoCTest {

    private static Logger log = Logger.getLogger(IoCTest.class);

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = null;
        try {
            ctx = new AnnotationConfigApplicationContext(AppConfig.class);
//            User user = (User) ctx.getBean("user");
            User user = ctx.getBean(User.class);
            System.out.println(user.getId());
            System.out.println(user.getUserName());
            System.out.println(user.getNote());

            User2 user2 = (User2) ctx.getBean("user2");
            System.out.println(user2.getId());
            System.out.println(user2.getUserName());
            System.out.println(user2.getNote());

//            DataSource data = ctx.getBean(DataSource.class);
//            System.out.println(data.getConnection().getMetaData().getDatabaseProductName());

            Person person = ctx.getBean(BusinessPerson.class);
            person.service();

            Person person1 = ctx.getBean(Person.class);
            person1.service();

            // 获取两次Cat
            Cat cat1 = ctx.getBean(Cat.class);
            Cat cat2 = ctx.getBean(Cat.class);
            // == 位运算，判断Cat1、Cat2是否为同一对象
            System.out.println(cat1 == cat2);
            log.info(user.getUserName());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ctx != null) {
                ctx.close();
            }
        }
    }
}
