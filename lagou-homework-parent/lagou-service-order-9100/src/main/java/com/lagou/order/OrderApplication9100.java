package com.lagou.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.lagou.order.mapper")
@EnableDiscoveryClient  //当前项目作为注册中心Client, 注册到注册中心
@EnableFeignClients     //开启Feign=RestTemplate+Ribbon+Hystrix
public class OrderApplication9100 {
    public static void main(String[] args){
        SpringApplication.run(OrderApplication9100.class,args);
    }
}
