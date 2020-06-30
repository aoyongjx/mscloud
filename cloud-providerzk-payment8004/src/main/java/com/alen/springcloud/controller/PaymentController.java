package com.alen.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @Description: $
 * @Param: $
 * @return: $
 * @Author: alen.ao
 * @date: $
 */
@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping(value = "/payment/zk")
    public String paymentZK() {
        return "springcloud with zk:" + serverPort + "\t" + UUID.randomUUID().toString();
    }
}
