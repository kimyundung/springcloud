package com.lagou.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer  // 注册中心(Eureka)
public class EurekaApplication9301 {
    public static void main(String[] args){
        SpringApplication.run(EurekaApplication9301.class,args);
    }
}
