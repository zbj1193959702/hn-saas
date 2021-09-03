package com.hn.saas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * /{application}-{profile}.yml
 * /读取的配置文件名-环境配置项 （默认为master分支）
 * 如：http://localhost:5001/microservice-config-application-dev.yml
 *
 * /{application}/{profile}[/{label}]
 * /读取的配置文件名/环境配置项/分支名
 * 如：http://localhost:5001/microservice-config-application/dev/master
 *
 * /{label}/{application}-{profile}.yml
 * /分支名/读取的配置文件名/环境配置项
 * 如：http://localhost:5001/master/microservice-config-application-dev.yml
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigServiceApplication.class, args);
    }
}
