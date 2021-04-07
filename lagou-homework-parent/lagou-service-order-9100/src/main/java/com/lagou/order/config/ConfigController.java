package com.lagou.order.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/config")
@RefreshScope   //手动刷新配置文件
public class ConfigController {

    @Value("${mysql.user}")
    private String user;
    @Value(("${person.name}"))
    private String name;
    @Value(("${person.age}"))
    private String age;

    @GetMapping("/query")
    public String getConfigInfo(){
        return user+", " + name + ", " + age;
    }
}
