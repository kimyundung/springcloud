package com.lagou.order.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lagou.common.Orders;
import com.lagou.common.OrdersVO;
import com.lagou.order.feign.GoodsFeign;
import com.lagou.order.mapper.OrderMapper;
import com.lagou.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public Orders queryById(Integer id) {
        return orderMapper.selectById(id);
    }

    @Override
    public PageInfo<Orders> queryAll(OrdersVO ordersVO) {
        //分页信息
        PageHelper.startPage(ordersVO.getPagenum(),ordersVO.getPagesize());
        //条件查询
        List<Orders> ordersList = orderMapper.selectAll(ordersVO);
        //分页后的信息
        PageInfo<Orders> ordersPageInfo = new PageInfo<>(ordersList);
        //返回结果
        return ordersPageInfo;
    }

    @Autowired
    private GoodsFeign goodsFeign;
    @Override
    public List<Object> queryGoodsByOid(Integer oid) {
        // 1.获取订单相关商品ID列表
        List<Integer> gidList = orderMapper.selectGoodsIdByOid(oid);
        // 2.通过商品ID, 调用商品微服务
        List<Object> objectList = new ArrayList<>();
        System.out.println("----------------- start 9100");
        for(Integer id : gidList) {
            Map<String, Object> map = goodsFeign.queryById(id);
            System.out.println(">>>>>>>>>>>> " + map);
            //发生熔断直接返回空列表
            if(map == null){
                return new ArrayList<Object>();
            }
            Object data = map.get("data");
            objectList.add(data);
        }
        System.out.println("----------------- end 9100");
        return objectList;
    }
}
