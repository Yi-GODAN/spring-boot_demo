package com.springboot.chapter5.plugin;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;

import java.sql.Statement;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

// 拦截SQL查询方法
@Intercepts(value = @Signature(type = StatementHandler.class,
        method = "query", args = {Statement.class, ResultHandler.class}))

/**
 * @Program: demo
 * @Description:
 * @Author: YiMing
 * @Created: 2020/07/10 22:14
 */
public class TimePlugin implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        long start = System.currentTimeMillis();
        // 相当于statement的query方法的调用
        Object obj = invocation.proceed();
        long end = System.currentTimeMillis();
        System.out.println("耗时【" + (end - start) + "】毫秒");
        return obj;
    }

    @Override
    public Object plugin(Object target) {
        // 生成代理对象
        return Plugin.wrap(target, this);
    }

    // 设置参数
    @Override
    public void setProperties(Properties properties) {
        Set<Object> keySet = properties.keySet();
        Iterator<Object> iterator = keySet.iterator();
        while (iterator.hasNext()) {
            String key = (String) iterator.next();
            String value = properties.getProperty(key);
            System.out.println("【" + key + "】->【" + value + "】");
        }
    }
}
