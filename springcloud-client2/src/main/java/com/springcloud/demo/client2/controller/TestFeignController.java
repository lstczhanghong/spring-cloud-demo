package com.springcloud.demo.client2.controller;

import com.springcloud.demo.client2.service.TestFeignIntercept;
import com.springcloud.demo.dto.ClientDto;
import com.springcloud.demo.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/testFeign")
public class TestFeignController {

    @Autowired
    private TestFeignIntercept testFeignIntercept;

    /**
     * 获取信息
     *
     * @return
     */
    @GetMapping
    public R getFeignMessage() {
        return this.testFeignIntercept.getFeignMassage();
    }


    /**
     * 获取信息
     *
     * @return
     */
    @GetMapping("{id}")
    public ClientDto getClientById(@PathVariable Integer id) {
        return this.testFeignIntercept.getClientById(id);
    }
}
