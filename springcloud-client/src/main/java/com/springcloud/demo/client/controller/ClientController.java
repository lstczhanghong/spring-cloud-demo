package com.springcloud.demo.client.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.springcloud.demo.client.entity.Client;
import com.springcloud.demo.client.service.ClientService;
import com.springcloud.demo.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * client的前端控制器
 * </p>
 *
 * @since 2019-05-24
 */
@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    private ClientService clientService;

    /**
     * 新增client
     *
     * @param client client对象
     * @return
     */
    @PostMapping
    public R addClient(@RequestBody Client client) {
        return R.suc(this.clientService.save(client));
    }

    /**
     * 新增client
     *
     * @param client client对象
     * @return
     */
    @PutMapping("{id}")
    public R updateClient(@PathVariable(value = "id") Long id, @RequestBody Client client) {
        return R.suc(this.clientService.saveOrUpdate(client));
    }

    /**
     * 根据id获取client
     *
     * @param id client的id
     * @return
     */
    @GetMapping("/{id}")
    public R getClientById(@PathVariable Integer id) {
        return R.suc(this.clientService.getById(id));
    }

    /**
     * 根据id删除client
     *
     * @param id client的id
     * @return
     */
    @DeleteMapping("/{id}")
    public R removeClient(@PathVariable Integer id) {
        return R.suc(this.clientService.removeById(id));
    }

    @GetMapping("/page")
    public R getClientPage(Page page, Client client) {
//        return R.suc(this.clientService.page(page, new QueryWrapper<>(client)));
        return R.suc(this.clientService.getClientPage(page, client));
    }
}