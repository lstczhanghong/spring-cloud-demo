package com.springcloud.demo.client.conf;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.wall.WallConfig;
import com.alibaba.druid.wall.WallFilter;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @auther:zh
 * @date:2020/3/24
 */
@Configuration
public class DruidConfiguration {
    /**
     * ruid内置提供了一个StatViewServlet用于展示Druid的统计信息，这个StatViewServlet的用途包括：
     * 提供监控信息展示的html页面
     * 提供监控信息的JSON API
     *
     * @return
     */
    @Bean
    public ServletRegistrationBean druidServlet() {
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean();
        //stat视图设置
        servletRegistrationBean.setServlet(new StatViewServlet());
        servletRegistrationBean.addUrlMappings("/druid/*"); //对应路径映射
        Map<String, String> initParameters = new HashMap();
        initParameters.put("loginUsername", "admin"); // 登录监控页面的用户名
        initParameters.put("loginPassword", "admin"); // 登录监控页面的密码
        initParameters.put("resetEnable", "false"); // 禁用HTML页面上的“Reset All”功能
        initParameters.put("allow", ""); // IP白名单 (没有配置或者为空，则允许所有访问)
        initParameters.put("deny", "192.168.20.38");// IP黑名单 (存在共同时，deny优先于allow),如果满足deny的话提示:Sorry, you are not permitted to view this page.
        servletRegistrationBean.setInitParameters(initParameters);
        return servletRegistrationBean;
    }

    /**
     * 配置SQL防火墙过滤器---WallFilter
     * Druid携带一个防火墙过滤器，有效控制系统内SQL的执行权限，禁止非法SQL行为
     *
     * @return
     */
    @Bean(name = "wallFilter")
    public WallFilter wallFilter() {
        WallConfig wallConfig = new WallConfig();
        wallConfig.setDeleteWhereNoneCheck(true);//进行无条件清空表格的检查（拦截）
        wallConfig.setMultiStatementAllow(true); //允许sql批量操作
        wallConfig.setNoneBaseStatementAllow(true);//允许非基本语句的其他语句
        WallFilter wallfilter = new WallFilter();
        wallfilter.setConfig(wallConfig);
        return wallfilter;
    }
}
