package com.springboot.chapter3.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

/**
 * @Program: demo
 * @Description:
 * @Author: YiMing
 * @Created: 2020/06/26 15:37
 */
@SpringBootApplication(scanBasePackages = "com.springboot.chapter3")
//@PropertySource(value = {"classpath:jdbc.properties"}, ignoreResourceNotFound = true)  // ignoreResourceNotFound = true 忽略找不到资源的异常
//@ImportResource(value = {"classpath:spring-other.xml"})
public class Chapter3Application {

    public static void main(String[] args) {
        SpringApplication.run(com.springboot.chapter3.Chapter3Application.class, args);
    }
}
