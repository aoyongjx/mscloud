package com.alen.springcloud.controller;

import com.alen.springcloud.domain.CommonResult;
import com.alen.springcloud.domain.Order;
import com.alen.springcloud.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
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
public class OrderController {

    @Resource
    private OrderService orderService;

    @GetMapping(value = "/order/create")
    public CommonResult create(Order order) {
        orderService.create(order);
        return new CommonResult(200, "订单创建成功！");
    }

    @GetMapping(value = "/order/test")
    public CommonResult test() {
        return new CommonResult(200, "测试成功！");
    }
}
