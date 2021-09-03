package com.hn.saas;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * create by biji.zhao on 2021/9/1
 */

@MapperScan("com.hn.saas.mapper")
@EnableHystrix   // 支持熔断
@EnableEurekaClient
@SpringBootApplication
public class ProductProviderHystrixApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductProviderHystrixApplication.class, args);
    }
}
