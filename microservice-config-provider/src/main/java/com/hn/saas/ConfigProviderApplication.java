package com.hn.saas;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * create by biji.zhao on 2021/8/30
 */
@MapperScan("com.hn.saas.mapper")
@EnableEurekaClient
@SpringBootApplication
public class ConfigProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigProviderApplication.class, args);
    }
}
