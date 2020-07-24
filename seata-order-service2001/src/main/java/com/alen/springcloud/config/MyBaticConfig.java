package com.alen.springcloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Description: $
 * @Param: $
 * @return: $
 * @Author: alen.ao
 * @date: $
 */
@Configuration
@MapperScan({"com.alen.springcloud.dao"})
public class MyBaticConfig {
}
