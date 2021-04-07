package com.lagou.gateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * 自定义全局网关过滤器
 * 实现两个接口
 * 1.GlobalFilter (全局过滤器)
 * 2.Ordered (指定过滤器的执行顺序)
 */
@Component //交给spring管理
public class BlackListFilter implements GlobalFilter, Ordered {

    /**
     * 全局过滤器
     * @param exchange 封装了request和response对象的上下文
     * @param chain 网关过滤器链（包含全局过滤器和单路由过滤器）
     * @return
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        System.out.println(">>>>>>>>>>>>> " + 9000);
        // 合法请求，放行，执行后续的过滤器
        return chain.filter(exchange);
    }

    /**
     * 定义过滤的顺序
     * 返回值的越小, 优先级越高
     * @return
     */
    @Override
    public int getOrder() {
        return 0;
    }
}
