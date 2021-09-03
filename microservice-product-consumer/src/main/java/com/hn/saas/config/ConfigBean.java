package com.hn.saas.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * create by biji.zhao on 2021/8/30
 */
@Configuration
public class ConfigBean {
    /**
     *  注解@Bean返回的类默认以方法名称为类的名称
     *  注解@LoadBalanced
     *   Ribbon工作分为两步：
     *      第1步先选择 Eureka Server ,它优先选择在同一个区域内负载较少的server
     *      第2步再根据用户指定的策略，在从 Eureka Server 获取的服务注册列表中选择一个地址。 其中Ribbon提供
     *      了多种策略：比如轮询、随机和根据响应时间加权等。
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(@Qualifier("simpleClientHttpRequestFactory") ClientHttpRequestFactory factory) {
        return new RestTemplate(factory);
    }

    @Bean
    public ClientHttpRequestFactory simpleClientHttpRequestFactory() {
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setReadTimeout(5000);//单位为ms
        factory.setConnectTimeout(5000);//单位为ms
        return factory;
    }
}
