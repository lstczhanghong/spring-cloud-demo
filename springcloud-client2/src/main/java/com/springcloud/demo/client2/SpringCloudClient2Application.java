package com.springcloud.demo.client2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @auther:zh
 * @date:2020/3/16
 */
@EnableEurekaClient
@SpringBootApplication
@EnableFeignClients
public class SpringCloudClient2Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudClient2Application.class, args);
    }
}
