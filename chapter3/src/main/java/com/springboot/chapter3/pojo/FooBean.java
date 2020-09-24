package com.springboot.chapter3.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Program: demo
 * @Description:
 * @Author: YiMing
 * @Created: 2020/06/27 20:21
 */
@Component
public class FooBean {
    // 读取属性文件，"$"代表引用属性文件
    @Value("${database.driverName}")
    String driver = null;

    // 调用静态属性和静态方法，"#"代表 Spring EL(Spring 表达式)，进行运算。T(...)代表引入类。
    // java.lang.*包的类默认加载，其它包需写全限定名。
    @Value("#{T(Math).PI}")
    private double pi;

    @Value("#{T(System).currentTimeMillis()}")
    private Long now = null;

    // 赋值字符串
    @Value("#{'使用 Spring EL 赋值字符串'}")
    private String str = null;

    // 科学计数法赋值
    @Value("#{9.3E3}")
    private double d;

    // 赋值浮点数
    @Value("#{3.14}")
    private float pi2;

    // 获取其它 Spring Bean 属性来给当前的 Bean 属性赋值
    @Value("#{user.userName}")
    private String userName = null;

    // "?" 代表非空判断，如果非空则转换为大写
    @Value("#{user.userName?.toUpperCase()}")
    private String userNameUpper = null;

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public double getPi() {
        return pi;
    }

    public void setPi(double pi) {
        this.pi = pi;
    }

    public Long getNow() {
        return now;
    }

    public void setNow(Long now) {
        this.now = now;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public double getD() {
        return d;
    }

    public void setD(double d) {
        this.d = d;
    }

    public float getPi2() {
        return pi2;
    }

    public void setPi2(float pi2) {
        this.pi2 = pi2;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserNameUpper() {
        return userNameUpper;
    }

    public void setUserNameUpper(String userNameUpper) {
        this.userNameUpper = userNameUpper;
    }
}
