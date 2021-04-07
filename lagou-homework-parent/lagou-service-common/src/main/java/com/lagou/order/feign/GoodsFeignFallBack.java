package com.lagou.order.feign;

import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 熔断器触发之后的回调逻辑(降级)
 */
@Component  //交给spring管理
public class GoodsFeignFallBack implements GoodsFeign {
    @Override
    public String getPort() {
        return "-1";
    }

    @Override
    public Map<String, Object> queryById(Integer id) {
        return null;
    }
}
