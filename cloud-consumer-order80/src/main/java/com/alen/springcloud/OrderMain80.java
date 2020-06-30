package com.alen.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author ：alen.ao
 * @date ：Created in 2020/6/12 15:32
 * @description：消费者
 * @modified By：
 * @version: 1.0$
 */
@SpringBootApplication
@EnableEurekaClient
// 添加自定义的规则,正启动该微服务的时候就能去加载我们自定义的Ribbon配置，从而使配置生效
//@RibbonClient(name = "CLOUD-PAYMENT-SERVICE", configuration = MySelfRule.class)
public class OrderMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain80.class, args);
    }
}
