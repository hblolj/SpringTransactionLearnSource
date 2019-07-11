package com.hblolj.springtransactionlearn;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableAspectJAutoProxy(exposeProxy = true)
@SpringBootApplication
@MapperScan(basePackages = "com.hblolj.springtransactionlearn.dao")
public class SpringTransactionLearnApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringTransactionLearnApplication.class, args);
    }

    @Bean
    public Object testBean(PlatformTransactionManager platformTransactionManager){
        System.out.println(platformTransactionManager.getClass().getName());
        return new Object();
    }

}
