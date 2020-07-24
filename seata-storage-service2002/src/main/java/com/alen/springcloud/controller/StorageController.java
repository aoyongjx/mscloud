package com.alen.springcloud.controller;

import com.alen.springcloud.domain.CommonResult;
import com.alen.springcloud.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
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
public class StorageController {

    @Resource
    private StorageService storageService;

    @RequestMapping("/storage/decrease")
    public CommonResult decrease(Long productId,Integer count) {
        log.info("============>2002 StorageController" +  "--" + productId + "--" + count);
        storageService.decrease(productId, count);
        return new CommonResult(200,"扣减库存成功!");
    }
}
