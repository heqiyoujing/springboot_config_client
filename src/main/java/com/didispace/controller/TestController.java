package com.didispace.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class TestController {

    /**
     * https://blog.csdn.net/mr_errol/article/details/78921710
     * 发送post请求到client，更新配置文件,报错Full authentication is required to access this resource
     * 这是由于client服务开启了权限拦截,在配置文件bootrap.properties中增加一句management.security.enabled=false
     * RabbitMQ若使用自己创建的用户，socket closed权限不足，所以改使用guest
     */

    @Value("${info.from}")
    private String from;

    @RequestMapping("/from")
    public String from() {
        return this.from;
    }

}
