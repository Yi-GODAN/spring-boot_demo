package com.springboot.chapter3.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @Program: demo
 * @Description:
 * @Author: YiMing
 * @Created: 2020/06/27 15:16
 */
public class DatabaseConditional implements Condition {
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        // 取出环境配置
        Environment env = conditionContext.getEnvironment();
        // 判断属性文件是否存在对应的数据库配置
        return env.containsProperty("database.diverName")
                && env.containsProperty("database.url")
                && env.containsProperty("database.username")
                && env.containsProperty("database.password");
    }
}
