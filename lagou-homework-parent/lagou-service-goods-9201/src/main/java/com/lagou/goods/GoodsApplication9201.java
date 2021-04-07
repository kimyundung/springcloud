package com.lagou.goods;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@MapperScan("com.lagou.goods.mapper")
@EnableDiscoveryClient  //当前项目作为注册中心的Client, 注册到注册中心
@EnableFeignClients(basePackages = "com.lagou.goods.feign")
public class GoodsApplication9201 {
    public static void main(String[] args) {
        SpringApplication.run(GoodsApplication9201.class, args);
    }
}
