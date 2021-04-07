package com.lagou.goods.service;

import com.github.pagehelper.PageInfo;
import com.lagou.common.Goods;
import com.lagou.common.GoodsVO;

import java.util.List;

public interface GoodsService {
    /**
     * 通过ID查询商品
     * @param id
     * @return
     */
    public Goods queryById(Integer id);

    /**
     * 通过ID删除商品
     * @param id
     */
    public Integer deleteById(Integer id);

    /**
     * 通过ID编辑商品
     * @param goods
     */
    public Integer updateGoods(Goods goods);

    public PageInfo<Goods> query(GoodsVO goodsVO);
}
