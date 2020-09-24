package com.springboot.chapter3.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Program: demo
 * @Description:
 * @Author: YiMing
 * @Created: 2020/06/27 20:46
 */
@Component
public class FooBean2 {

    // 数学运算
    @Value("#{1+2}")
    private int run;

    // 浮点数比较运算
    @Value("#{fooBean.pi2 == 3.14f}")
    private boolean piFlag;

    // 字符串比较运算
    @Value("#{fooBean.str eq 'Sprint Boot'}")
    private boolean strFlag;

    // 字符串连接
    @Value("#{fooBean.str + ' 连接字符串'}")
    private String strApp = null;

    // 三目运算
    @Value("#{fooBean.d > 1000 ? '大于' : '小于'}")
    private String resultDesc = null;

    public int getRun() {
        return run;
    }

    public void setRun(int run) {
        this.run = run;
    }

    public boolean isPiFlag() {
        return piFlag;
    }

    public void setPiFlag(boolean piFlag) {
        this.piFlag = piFlag;
    }

    public boolean isStrFlag() {
        return strFlag;
    }

    public void setStrFlag(boolean strFlag) {
        this.strFlag = strFlag;
    }

    public String getStrApp() {
        return strApp;
    }

    public void setStrApp(String strApp) {
        this.strApp = strApp;
    }

    public String getResultDesc() {
        return resultDesc;
    }

    public void setResultDesc(String resultDesc) {
        this.resultDesc = resultDesc;
    }
}
