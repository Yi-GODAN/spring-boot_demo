package com.springboot.chapter4.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @Program: demo
 * @Description:
 * @Author: YiMing
 * @Created: 2020/06/28 18:39
 */
@Configuration
@ComponentScan("com.springboot.chapter4")
// 驱动 Spring AOP 注解
@EnableAspectJAutoProxy
public class AppConfig {
}
