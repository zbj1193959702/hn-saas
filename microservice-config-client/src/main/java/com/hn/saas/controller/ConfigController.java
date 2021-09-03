package com.hn.saas.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * create by biji.zhao on 2021/9/1
 */
@RestController
public class ConfigController {

    @Value("${spring.application.name}")
    private String applicationName;

    @Value("${server.port}")
    private String port;

    @GetMapping("/config")
    public String getConfig() {
        String content = "applicationName:" + applicationName + ", port:" + port;
        System.out.println("=======================");
        System.out.println("content: " + content);
        return content;
    }
}
