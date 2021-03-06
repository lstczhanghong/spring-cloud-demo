package com.springcloud.demo.client.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.springcloud.demo.client.entity.Client;
import com.springcloud.demo.client.mapper.ClientMapper;
import com.springcloud.demo.client.service.ClientService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lai.guanfu
 * @since 2020-03-26
 */
@Service
public class ClientServiceImpl extends ServiceImpl<ClientMapper, Client> implements ClientService {

    @Override
    public IPage<Client> getClientPage(Page page, Client client) {
        return this.baseMapper.selectClientPage(page,client);
    }
}
