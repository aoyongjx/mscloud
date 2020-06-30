package com.alen.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author ：alen.ao
 * @date ：Created in 2020/6/15 14:35
 * @description：集群7002
 * @modified By：
 * @version: 1.0$
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaMain7002 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaMain7002.class, args);
    }
}
