package com.springboot.chapter5.main;

import com.springboot.chapter5.dao.MyBatisFoodDao;
import com.springboot.chapter5.plugin.TimePlugin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.annotation.PostConstruct;
import java.util.Properties;

/**
 * @Program: demo
 * @Description:
 * @Author: YiMing
 * @Created: 2020/07/02 21:13
 */
@SpringBootApplication(scanBasePackages = "com.springboot.chapter5")
// 驱动JPA编程，并指定接口扫描路径
@EnableJpaRepositories(basePackages = "com.springboot.chapter5")
// 驱动JPA实体类的扫描，并指定扫描路径
@EntityScan(basePackages = "com.springboot.chapter5")
@MapperScan(
        basePackages = "com.springboot.chapter5",   // 指定扫描包
//        sqlSessionFactoryRef = "sqlSessionFactory", // 指定sqlSessionFactory
//        sqlSessionTemplateRef = "sqlSessionTemplate", // 指定sqlSessionTemplate
//        markerInterface = xxx,   // 使用接口限定，使用率不高
        annotationClass = Mapper.class) // 限定扫描的注解
public class Chapter5Application {

    public static void main(String[] args) {
            SpringApplication.run(Chapter5Application.class, args);
    }

    @Autowired
    private SqlSessionFactory sqlSessionFactory = null;

/*    @PostConstruct  // Spring IoC Bean 的生命周期的方法
    public void initMyBatis() {
        TimePlugin tp = new TimePlugin();
        Properties properties = new Properties();
        properties.setProperty("key1", "value1");
        properties.setProperty("key2", "value2");
        properties.setProperty("key3", "value3");
        // 设置插件的参数
        tp.setProperties(properties);
        // 给MyBatis上下文增加一个插件
        sqlSessionFactory.getConfiguration().addInterceptor(tp);
    }*/

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate = null;

/*    @Bean(name = "myBatisFoodDao")
    public MapperFactoryBean<MyBatisFoodDao> intiMyBatisFoodDao() {
        MapperFactoryBean<MyBatisFoodDao> myBatisFoodDao = new MapperFactoryBean<>();
        myBatisFoodDao.setSqlSessionTemplate(sqlSessionTemplate);
        myBatisFoodDao.setMapperInterface(MyBatisFoodDao.class);
        return myBatisFoodDao;
    }*/

/*    @Bean
    public MapperScannerConfigurer initMapperScannerConfig() {
        // 定义扫描器实例
        MapperScannerConfigurer msf = new MapperScannerConfigurer();
        // 关联 sqlSessionFactory 或 setSqlSessionTemplateBeanName，springboot会自动装配
        msf.setSqlSessionFactoryBeanName("sqlSessionFactory");
        *//**
         * 如果 setSqlSessionFactoryBeanName 和 setSqlSessionTemplateBeanName 同时设置，
         * 那么后者会覆盖前者，因为后者优先级更高
         *//*
//        msf.setSqlSessionTemplateBeanName("sqlSessionTemplate");
        // 指定扫描器扫描的包
        msf.setBasePackage("com.springboot.chapter5.dao");
//        msf.setMarkerInterface(superClass);   基于接口扫描，通过继承某个接口限制扫描（基本不使用）
        // 限制只扫描的标注了 @Mapper 的接口
        msf.setAnnotationClass(Mapper.class);
        return msf;
    }*/
}
