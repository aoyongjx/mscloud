package com.alen.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Description: zookeeper为注册中心$
 * @Param: $
 * @return: $
 * @Author: alen.ao
 * @date: 2020-06-16$
 */
@SpringBootApplication
@EnableDiscoveryClient // 用于向使用consul或者zk作为注册中心注册服务
public class PaymentMain8004 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8004.class, args);
    }
}
