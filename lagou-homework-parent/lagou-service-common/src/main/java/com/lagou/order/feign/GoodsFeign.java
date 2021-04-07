package com.lagou.order.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Map;

/**
 * 自定义Feign接口, 调用GoodsService
 */
@FeignClient(value = "lagou-service-goods", fallback = GoodsFeignFallBack.class)
public interface GoodsFeign {

    @GetMapping("/goods/port")
    public String getPort();

    //通过ID查询商品
    @GetMapping("/goods/query/{id}")
    public Map<String,Object> queryById(@PathVariable Integer id);
}
