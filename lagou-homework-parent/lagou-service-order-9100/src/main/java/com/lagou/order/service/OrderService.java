package com.lagou.order.service;

import com.github.pagehelper.PageInfo;
import com.lagou.common.Goods;
import com.lagou.common.Orders;
import com.lagou.common.OrdersVO;

import java.util.List;
import java.util.Map;

public interface OrderService {

    /**
     * 根据订单ID查询订单
     * @param id
     * @return
     */
    public Orders queryById(Integer id);

    /**
     * 条件分页查询订单
     * @param ordersVO
     * @return
     */
    public PageInfo<Orders> queryAll(OrdersVO ordersVO);

    /**
     * 根据订单ID查询商品列表
     * @param oid 订单ID
     * @return
     */
    public List<Object> queryGoodsByOid(Integer oid);

}
