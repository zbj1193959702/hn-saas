package com.hn.saas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * create by biji.zhao on 2021/8/30
 */
@SpringBootApplication
@EnableEurekaClient //向服务注册中心进行注册
public class ProductConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductConsumerApplication.class, args);
    }
}
