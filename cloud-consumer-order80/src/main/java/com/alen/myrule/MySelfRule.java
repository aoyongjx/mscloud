package com.alen.myrule;

import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Configuration;
import com.netflix.loadbalancer.IRule;

/**
 * @Description: $
 * @Param: $
 * @return: $
 * @Author: alen.ao
 * @date: $
 */
@Configuration
public class MySelfRule {
    public IRule myRule() {
        return new RandomRule(); // 定义为随机
    }
}
