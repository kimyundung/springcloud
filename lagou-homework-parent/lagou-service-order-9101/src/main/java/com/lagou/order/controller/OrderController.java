package com.lagou.order.controller;

import com.github.pagehelper.PageInfo;
import com.lagou.common.Orders;
import com.lagou.common.OrdersVO;
import com.lagou.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    /**
     * 根据订单id查询订单
     * @param id
     * @return
     */
    @GetMapping("/query/{id}")
    public Map<String,Object> queryById(@PathVariable Integer id){
        Orders orders = orderService.queryById(id);
        return getDataMap(orders);
    }

    /**
     * 分页查询
     * - pageSize = 10
     * - 查询条件：订单创建时间范围、订单状态（未支付、已支付、已失效、已删除）
     *
     * 返回类型：Map（list:订单集合、total:总条目数）
     * @param ordersVO
     * @return
     */
    @GetMapping("/query")
    public Map<String,Object> queryAll(OrdersVO ordersVO){
        PageInfo<Orders> ordersPageInfo = orderService.queryAll(ordersVO);
        return getDataMap(ordersPageInfo);
    }

    /**
     * 根据订单id查询商品列表
     * 调用商品微服务
     * feign接口调用，负载均衡
     * 超时时间5秒触发熔断
     * 熔断后服务降低，返回空商品列表
     * 线程池隔离，并发线程数16，最大队列10000，队列拒绝阈值6000
     * @param oid
     * @return
     */
    @GetMapping("/qeuryGoods/{oid}")
    public Map<String,Object> queryGoodsByOid(@PathVariable Integer oid){
        List<Object> objectList = orderService.queryGoodsByOid(oid);
        return getDataMap(objectList);
    }



    // 数据+结果的返回
    private Map<String,Object> getDataMap(Object object){
        Map<String, Object> map = new HashMap<>();
        if(object!=null){
            map.put("data",object);
            map.put("status",200);
            map.put("msg","success");
        } else {
            map.put("status",500);
            map.put("msg","fail");
        }
        return map;
    }

    // 结果的返回
    private Map<String, Object> getMap(Integer i) {
        Map<String, Object> map = new HashMap<>();
        if(i==1){
            map.put("status",200);
            map.put("msg","success");
        } else {
            map.put("status",500);
            map.put("msg","fail");
        }
        return map;
    }
}
