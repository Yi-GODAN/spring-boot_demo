package com.springboot.chapter4.main;

import com.springboot.chapter4.config.AppConfig;
import com.springboot.chapter4.intercept.DinnerInterceptor;
import com.springboot.chapter4.service.DinnerService;
import com.springboot.chapter4.validator.BreakfastValidator;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Date;

/**
 * @Program: demo
 * @Description:
 * @Author: YiMing
 * @Created: 2020/06/28 10:10
 */
public class AppMain {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = null;
        try {
            ctx = new AnnotationConfigApplicationContext(AppConfig.class);
            // Spring Bean
            DinnerService service = ctx.getBean("lunchServiceImpl", DinnerService.class);
            // 转换为 BreakfastValidator 接口，可以调用为 Spring Bean 增强的 validate 方法
//            BreakfastValidator validator = (BreakfastValidator) service;
//            String describe = "";
//            if (validator.validate(describe)) {
//                service.have(describe, new Date());
//            } else {
//                System.out.println("还没有指定具体吃啥 0.0 ");
//            }
            String describe = "牛肉火锅";
            service.have(describe, new Date());
        } finally {
            ctx.close();
        }
    }

    private static DinnerInterceptor getInterceptor() {
        return new DinnerInterceptor() {
            @Override
            public void beforeDinner() {
                System.out.println("饭前洗手");
            }

            @Override
            public void afterThrowing() {
                System.out.println("处理急事");
            }

            @Override
            public void afterDinner() {
                System.out.println("饭后清洗餐具");
            }

            @Override
            public void after() {
                System.out.println("处理剩菜剩饭");
            }
        };
    }
}
