package com.alen.springcloud.controller;

import com.alen.springcloud.entities.CommonResult;
import com.alen.springcloud.entities.Payment;
import com.alen.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author ：alen.ao
 * @date ：Created in 2020/6/12 12:04
 * @description：Controller
 * @modified By：
 * @version: 1.0$
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    // 服务发现
    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("**********==插入结果：" + result + "==结果");

        if (result > 0) {
            return new CommonResult(200, "插入数据库成功,serverPort:" + serverPort, result);
        }  else {
            return new CommonResult(999, "插入数据库失败,serverPort:" + serverPort, null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPayment(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("**********查询id=" + id);

        if (payment != null) {
            return new CommonResult(200, "查询数据库成功,serverPort:" + serverPort, payment);
        }  else {
            return new CommonResult(999, "查询数据库没有对应记录，查询ID:" + id + ",serverPort:" + serverPort, null);
        }
    }

    @GetMapping(value = "/payment/lb")
    public String getPaymentLB() {
        return serverPort;
    }

    // 服务发现
    @GetMapping(value = "/payment/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        for (String element : services) {
            log.info("********element:" + element);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }
        return this.discoveryClient;

    }

    // 测试openfeign超时，默认1S，这里设置3Ss
    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }

}
