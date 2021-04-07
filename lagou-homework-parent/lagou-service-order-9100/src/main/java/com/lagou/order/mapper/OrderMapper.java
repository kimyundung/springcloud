package com.lagou.order.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lagou.common.Goods;
import com.lagou.common.Orders;
import com.lagou.common.OrdersVO;

import java.util.List;

public interface OrderMapper extends BaseMapper<Orders> {

    /**
     * 条件查询所有订单
     * @param ordersVO
     * @return
     */
    public List<Orders> selectAll(OrdersVO ordersVO);

    /**
     * 根据订单ID查询商品ID列表
     * @param oid 订单ID
     * @return
     */
    public List<Integer> selectGoodsIdByOid(Integer oid);

}
