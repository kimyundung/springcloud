package com.lagou.goods.controller;

import com.github.pagehelper.PageInfo;
import com.lagou.common.Goods;
import com.lagou.common.GoodsVO;
import com.lagou.goods.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    //测试
    @Value("${server.port}")
    private String port;
    @GetMapping("/port")
    public String getPort(){
        System.out.println(">>>>>>>>>>>> " + 9201);
        return port;
    }

    @GetMapping("/query/{id}")
    public Map<String,Object> queryById(@PathVariable Integer id){
        System.out.println(">>>>>>>>>>>> " + System.currentTimeMillis() + " : " + 9201);
        Goods goods = goodsService.queryById(id);
        return getDataMap(goods);
    }

    @DeleteMapping("/delete/{id}")
    public Map<String,Object> deleteById(@PathVariable Integer id){
        Integer i = goodsService.deleteById(id);
        return getMap(i);
    }

    @PutMapping("/update/{id}")
    public Map<String,Object> updateById(@PathVariable Integer id, @RequestBody Goods goods){
        // 根据ID编辑商品
        goods.setId(id);
        Integer i = goodsService.updateGoods(goods);
        return getMap(i);
    }

    @GetMapping("/query")
    public Map<String,Object> query(GoodsVO goodsVO){
        System.out.println(goodsVO);
        PageInfo<Goods> goodsPageInfo = goodsService.query(goodsVO);
        return getDataMap(goodsPageInfo);
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
