package com.hn.saas.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;


/**
 * 如果数据源采用的是Druid，目前更新 GitHub 中的数据源配置，只有重启服务才能获取新配置，不然获取不到。
 * 那怎么办呢？
 *
 * 消息中线无法实现数据源动态切换的问题 因此需要单独配置 数据源
 */
@Configuration
public class DruidConfig {

    @RefreshScope //刷新数据源
    @ConfigurationProperties(prefix = "spring.datasource")   //绑定数据源配置
    @Bean
    public DataSource druid() {
        return new DruidDataSource();
    }
}
