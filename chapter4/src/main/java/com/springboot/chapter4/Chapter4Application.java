package com.springboot.chapter4;

import com.springboot.chapter4.aspect.MyAspect;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// 指定扫描包
//@SpringBootApplication(scanBasePackages = {"com.springboot.chapter4.aspect"})
public class Chapter4Application {

    // 定义切面
    public MyAspect initMyAspect() {
        return new MyAspect();
    }

    // 启动切面
    public static void main(String[] args) {
        SpringApplication.run(Chapter4Application.class, args);
    }

}
