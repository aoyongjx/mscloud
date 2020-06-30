package com.alen.springcloud.service;

import com.alen.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * 服务接口
 */
public interface PaymentService {

    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
