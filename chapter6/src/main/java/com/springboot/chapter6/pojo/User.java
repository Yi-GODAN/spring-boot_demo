package com.springboot.chapter6.pojo;

import com.springboot.chapter6.enumeraiton.SexEnum;
import org.apache.ibatis.type.Alias;

/**
 * @Program: demo
 * @Description:
 * @Author: YiMing
 * @Created: 2020/07/11 11:19
 */
@Alias("user")  // MyBatis 指定别名
public class User {

    private Long id = null;
    private String userName = null;
    private SexEnum sex = null;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public SexEnum getSex() {
        return sex;
    }

    public void setSex(SexEnum sex) {
        this.sex = sex;
    }

}
