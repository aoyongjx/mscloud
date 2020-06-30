package com.alen.springcloud.service.impl;

import com.alen.springcloud.dao.PaymentDao;
import com.alen.springcloud.entities.Payment;
import com.alen.springcloud.service.PaymentService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author ：alen.ao
 * @date ：Created in 2020/6/12 12:00
 * @description：服务实现
 * @modified By：
 * @version: 1.0$
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    public Payment getPaymentById(@Param("id") Long id) {
        return paymentDao.getPaymentById(id);
    }
}
