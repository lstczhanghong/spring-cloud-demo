package com.springcloud.demo.client2.service;

import com.springcloud.demo.dto.ClientDto;
import com.springcloud.demo.util.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "springcloud-client", name = "springcloud-client") //指向注册名为springcloud-client的服务
public interface TestFeignIntercept {

    /**
     * 内部接口，获取信息
     *
     * @return
     */
    @GetMapping("/test/feign")
    //指向springcloud-client中接口路径为/feign/test的接口
    R getFeignMassage();


    /**
     * 内部接口，获取信息
     *
     * @return
     */
    @GetMapping("/test/feign/client/{id}")
    ClientDto getClientById(@PathVariable Integer id);
}
