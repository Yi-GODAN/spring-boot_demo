package com.springboot.chapter4.proxy;

import com.springboot.chapter4.intercept.DinnerInterceptor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Program: demo
 * @Description:
 * @Author: YiMing
 * @Created: 2020/06/28 09:53
 */
public class DinnerProxy implements InvocationHandler {

    // 目标对象, 房东
    Object target = null;
    private DinnerInterceptor interceptor = null;

    // 建立代理对象和目标对象的关联关系（中介与房东签署合同）
    public static Object bind(Object target, DinnerInterceptor interceptor) {
        DinnerProxy dinnerProxy = new DinnerProxy();
        dinnerProxy.target = target;
        dinnerProxy.interceptor = interceptor;
        // 生成代理对象，然后将代理对象的逻辑放到 DinnerProxy 的 invoke 方法上
        Object proxy = Proxy.newProxyInstance(target.getClass().getClassLoader(),   // 类加载器
                target.getClass().getInterfaces(),  // 将代理对象挂载到什么接口之下
                dinnerProxy);   // 使用 DinnerProxy 的 invoke 方法作为代理逻辑
        return proxy;
    }

    // 实现代理逻辑的方法
    /**
     * 代理对象的逻辑（中介的服务）
     * @param proxy -- 代理对象
     * @param method -- 方法
     * @param args -- 参数
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        this.interceptor.beforeDinner();
        // 吃饭
        Object obj = null;
        boolean flag = false;
        try {
            obj = method.invoke(target, args);
        } catch (Exception e) {
            flag = true;
        }  finally {
            this.interceptor.after();
        }
        if (flag) {
            this.interceptor.afterThrowing();
        } else  {
            this.interceptor.afterDinner();
        }
        return obj;
    }
}
