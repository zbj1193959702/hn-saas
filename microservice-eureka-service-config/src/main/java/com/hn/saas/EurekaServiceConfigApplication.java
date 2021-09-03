package com.hn.saas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * create by biji.zhao on 2021/9/1
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServiceConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServiceConfigApplication.class, args);
    }
}
