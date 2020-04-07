package com.springcloud.demo.client;

import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 必须和启动main函数同包或者main函数的子包
 */
@Configuration
public class MPConfiguration {

    /**
     * 逻辑删除，mybatis plus 3.1.1后无需配置
     * @return
     */
    @Bean
    public ISqlInjector sqlInjector() {
        return new LogicSqlInjector();
    }
}