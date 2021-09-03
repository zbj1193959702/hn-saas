package com.hn.saas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 1、添加注解@EnableFeignClients后，spring 会扫描标记了@FeignClient 的接口生成代理类
 * 2、@FeignClient("服务名称 ") 即指定了服务名称，feign会从注册中心获取服务列表，并通过负载均衡算法进行服务调用
 * 3、在接口的方法上使用注解@GetMapping(value = "/product/list")，feign会根据url进行调用
 */
@SpringBootApplication
@EnableFeignClients(basePackages = "com.hn.saas.service")
@EnableEurekaClient // 向服务注册中心进行注册
public class ProductConsumerFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductConsumerFeignApplication.class, args);
    }
}
