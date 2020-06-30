package com.alen.springcloud.service;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Description: $
 * @Param: $
 * @return: $
 * @Author: alen.ao
 * @date: $
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String paymentInfo_OK(@PathVariable("id") Integer id) {
        return "************PaymentFallbackService paymentInfo_OK，成功！！！";
    }

    @Override
    public String paymentInfo_Timeout(@PathVariable("id") Integer id) {
        return "************PaymentFallbackService paymentInfo_Timeout，失败，请稍后再试！！！";
    }

}
