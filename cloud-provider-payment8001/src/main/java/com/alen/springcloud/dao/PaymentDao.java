package com.alen.springcloud.dao;

import com.alen.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Dao
 */
@Mapper
public interface PaymentDao {
    public int create(Payment  payment);

    public Payment getPaymentById(@Param("id") Long id);
}
