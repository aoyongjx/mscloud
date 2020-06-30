package com.alen.springcloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Logger;

/**
 * @Description: $
 * @Param: $
 * @return: $
 * @Author: alen.ao
 * @date: $
 */
@Configuration
public class FeignConfig {

    @Bean
    Logger.Level feignLoggerLever() {
        return Logger.Level.FULL;
    }
}
