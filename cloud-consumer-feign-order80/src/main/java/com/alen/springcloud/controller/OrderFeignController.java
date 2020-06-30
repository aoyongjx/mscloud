package com.alen.springcloud.controller;

import com.alen.springcloud.entities.CommonResult;
import com.alen.springcloud.entities.Payment;
import com.alen.springcloud.serivce.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description: $
 * @Param: $
 * @return: $
 * @Author: alen.ao
 * @date: $
 */
@RestController
@Slf4j
public class OrderFeignController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        return paymentFeignService.getPaymentById(id);
//        Payment payment = paymentFeignService.getPaymentById(id);
//        log.info("***********查询结果**************:{}", payment);
//        if (payment != null) {
//            return new CommonResult(200, "查询成功" + "\n 端口号：", payment);
//        } else {
//            return new CommonResult(444, "没有对应的记录，查询ID:" + id, null);
//        }
    }

    @GetMapping(value = "/consumer/payment/feign/timeout")
    public String paymentFeignTimeout() {
        //openfeign-ribbon 客户端默认等待时间1S
        return paymentFeignService.paymentFeignTimeout();
    }
}
