package com.springboot.chapter3.controller;

import com.springboot.chapter3.pojo.FooBean;
import com.springboot.chapter3.pojo.FooBean2;
import com.springboot.chapter3.pojo.definition.Person;
import com.springboot.other.pojo.Squirrel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @Program: demo
 * @Description:
 * @Author: YiMing
 * @Created: 2020/06/26 15:32
 */
@Controller
public class DiController {

    @Autowired
    private Person p = null;

    @Autowired
    private Squirrel squirrel = null;

    @Autowired
    private FooBean fooBean = null;

    @Autowired
    private FooBean2 fooBean2 = null;

    @RequestMapping("/test")
    @ResponseBody
    public Map<String, Boolean> test() {
        Map<String, Boolean> m = new HashMap<>();
        m.put("di", p != null);
        p.service();
        return m;
    }

    @RequestMapping("/squirrel")
    @ResponseBody
    public Map<String, Object> getSquirrelInfo() {
        Map<String, Object> m = new HashMap<>();
        boolean flag = (squirrel != null);
        String msg = flag? "注入成功" : "注入失败";
        m.put("success", flag);
        m.put("msg", msg);
        return m;
    }

    @RequestMapping("/foo")
    @ResponseBody
    public FooBean getFoo() {
        return fooBean;
    }

    @RequestMapping("/foo2")
    @ResponseBody
    public FooBean2 getFoo2() {
        return fooBean2;
    }
}
