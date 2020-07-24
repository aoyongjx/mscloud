package com.alen.springcloud.service.impl;

import com.alen.springcloud.dao.OrderDao;
import com.alen.springcloud.domain.Order;
import com.alen.springcloud.service.AccountService;
import com.alen.springcloud.service.OrderService;
import com.alen.springcloud.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Description: $
 * @Param: $
 * @return: $
 * @Author: alen.ao
 * @date: $
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;

    @Resource
    private StorageService storageService;

    @Resource
    private AccountService accountService;

    // 全局事务
    @GlobalTransactional(name = "fsp-create-order", rollbackFor = Exception.class)
    public void create(Order order) {
        log.info("============> 1、开始新建订单");
        // 1、新建订单
        orderDao.create(order);
        log.info("订单信息：" + order.getUserId() + "--" + order.getProductId()  + "--" + order.getCount()  + "--" + order.getMoney());

        log.info("============> 2、订单微服务开始调用库存，做扣减Count");
        // 2、扣减库存
        storageService.decrease(order.getProductId(), order.getCount());
        log.info("============> 2、订单微服务开始调用库存，做扣减Count==>End");

        log.info("============> 3、订单微服务开始调用库存，做扣减Money");
        // 3、扣减账户
        accountService.decrease(order.getUserId(), order.getMoney());
        log.info("============> 3、订单微服务开始调用库存，做扣减Money==>End");

        // 修改订单状态，从0到1，1代表已经完成
        log.info("============> 4、修改订单状态开始");
        orderDao.update(order.getUserId(), 0);
        log.info("============> 4、修改订单状态开始==>End");

        log.info("============> 新建订单==>End, is OK");
    }


}
