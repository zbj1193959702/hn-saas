package com.hn.saas;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * create by biji.zhao on 2021/8/30
 */
@MapperScan("com.hn.saas.mapper")
@SpringBootApplication
public class ProductProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductProviderApplication.class, args);
    }
}
