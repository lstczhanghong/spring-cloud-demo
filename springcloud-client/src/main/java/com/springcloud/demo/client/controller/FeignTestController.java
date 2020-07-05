package com.springcloud.demo.client.controller;

import com.springcloud.demo.client.entity.Client;
import com.springcloud.demo.client.service.ClientService;
import com.springcloud.demo.dto.ClientDto;
import com.springcloud.demo.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/test/feign")
public class FeignTestController {

    @Autowired
    private ClientService clientService;

    @GetMapping()
    public R getUser(){
        Map result = new HashMap();
        result.put("name", "xiaoming");
        result.put("sex", "male");
        result.put("age", 12);
        return R.suc(result);
    }

    /**
     * 根据id获取client
     *
     * @param id client的id
     * @return
     */
    @GetMapping("client/{id}")
    public ClientDto getClientById2(@PathVariable Integer id) {
        Client client = this.clientService.getById(id);
        ClientDto dto=new ClientDto();
        dto.setClientName(client.getClientName());
        dto.setClientPath(client.getClientPath());
        dto.setCreateBy(client.getCreateBy());
        dto.setCreateTime(client.getCreateTime());
        return dto;
    }

}
