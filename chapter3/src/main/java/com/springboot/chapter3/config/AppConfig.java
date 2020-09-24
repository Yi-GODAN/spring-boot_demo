package com.springboot.chapter3.config;

import com.springboot.chapter3.condition.DatabaseConditional;
import org.apache.commons.dbcp2.BasicDataSourceFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Indexed;

import javax.sql.DataSource;
import java.util.Properties;


/**
 * @Program: demo
 * @Description:
 * @Author: YiMing
 * @Created: 2020/06/25 21:58
 */
//
@Configuration // 标明为Spring的Java配置文件
@ComponentScan(basePackages = "com.springboot.chapter3",
    includeFilters = @ComponentScan.Filter(classes = Indexed.class)) // lazyInit = true 延迟初始化（默认false）
@ImportResource(value = {"classpath:spring-other.xml"})
public class AppConfig {

//    @Bean(name = "user")  // 代表将方法返回的对象，装配到IoC容器中，并设置Bean的名称为"user"
//    public User initUser() {
//        User user = new User();
//        user.setId(1L);
//        user.setUserName("user_name_1");
//        user.setNote("note");
//        return user;
//    }

//    @Bean(name = "dataSource", destroyMethod = "close")
//    public DataSource getDataSource() {
//        Properties props = new Properties();
//        props.setProperty("driver", "com.mysql.jdbc.Driver");
//        props.setProperty("url", "jdbc:mysql://localhost:3306/test_db?useUnicode=true&characterEncoding=utf8
//        &serverTimezone=GMT");
//        props.setProperty("username", "YiMing");
//        props.setProperty("password", "YiMing");
//        DataSource dataSource = null;
//        try {
//            dataSource = BasicDataSourceFactory.createDataSource(props);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return dataSource;
//    }
    /**
     * 条件装配Bean
     * 若Bean无法初始化，IoC容器继续进行装配，则系统将会抛出异常。这时则需要IoC停止装配。
     *
     * @Conditional注解配合Condition(org.springframework.context.annoation.Condition)接口，在Bean无法初始化时，即停。
     */
    @Bean(name = "dataSource", destroyMethod = "close")
    @Conditional(DatabaseConditional.class)     // 条件装配Bean，使用DatabaseConditional作为判断的依据
    @Profile(value = "dev")     // Profile参数为dev时，才装配Bean
    public DataSource getDataSource1(
            @Value("${database.driverName}") String driver,
            @Value("${database.url}") String url,
            @Value("${database.username}") String username,
            @Value("${database.password}") String password
    ) {
        Properties props = new Properties();
        props.setProperty("driver", driver);
        props.setProperty("url", url);
        props.setProperty("username", username);
        props.setProperty("password", password);
        DataSource dataSource = null;
        try {
            dataSource = BasicDataSourceFactory.createDataSource(props);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataSource;
    }

    @Bean(name = "dataSource", destroyMethod = "close")
    @Conditional(DatabaseConditional.class)     // 条件装配Bean，使用DatabaseConditional作为判断的依据
    @Profile(value = "test")     // Profile参数为test时，才装配Bean
    public DataSource getDataSource2(
            @Value("${database.driverName}") String driver,
            @Value("${database.url}") String url,
            @Value("${database.username}") String username,
            @Value("${database.password}") String password
    ) {
        Properties props = new Properties();
        props.setProperty("driver", driver);
        props.setProperty("url", url);
        props.setProperty("username", username);
        props.setProperty("password", password);
        DataSource dataSource = null;
        try {
            dataSource = BasicDataSourceFactory.createDataSource(props);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataSource;
    }
}
