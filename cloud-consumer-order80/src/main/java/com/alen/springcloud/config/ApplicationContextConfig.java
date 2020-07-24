package com.alen.springcloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author ：alen.ao
 * @date ：Created in 2020/6/12 15:42
 * @description：配置类
 * @modified By：
 * @version: 1.0$
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
//    @LoadBalanced //负载均衡使用
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}