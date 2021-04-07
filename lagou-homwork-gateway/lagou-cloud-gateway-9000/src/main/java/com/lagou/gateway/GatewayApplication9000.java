package com.lagou.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient //注册到eureka注册中心
public class GatewayApplication9000 {
    public static void main(String[] args){
        SpringApplication.run(GatewayApplication9000.class,args);
    }
}
