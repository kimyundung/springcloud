package com.lagou.goods;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@MapperScan("com.lagou.goods.mapper") //生成动态代理类
@EnableDiscoveryClient  //当前项目作为注册中心的Client, 注册到注册中心
@EnableFeignClients
public class GoodsApplication9200 {
    public static void main(String[] args) {
        SpringApplication.run(GoodsApplication9200.class, args);
    }
}
