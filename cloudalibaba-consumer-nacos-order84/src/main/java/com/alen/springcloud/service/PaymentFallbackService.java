package com.alen.springcloud.service;

import com.alen.springcloud.entities.CommonResult;
import com.alen.springcloud.entities.Payment;
import org.springframework.stereotype.Component;

/**
 * @Description: $
 * @Param: $
 * @return: $
 * @Author: alen.ao
 * @date: $
 */
@Component
public class PaymentFallbackService implements PaymentService {
    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>(44444,"服务降级返回-->PaymentFallbackService",new Payment(id,"errorService"));

    }
}
