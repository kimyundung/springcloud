package com.lagou.goods.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lagou.common.Goods;
import com.lagou.common.GoodsVO;
import com.lagou.goods.mapper.GoodsMapper;
import com.lagou.goods.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public Goods queryById(Integer id) {
        return goodsMapper.selectById(id);
    }

    @Override
    public Integer deleteById(Integer id) {
        int i = goodsMapper.deleteById(id);
        return i;
    }

    @Override
    public Integer updateGoods(Goods goods) {
        int i = goodsMapper.updateById(goods);
        return i;
    }

    @Override
    public PageInfo<Goods> query(GoodsVO goodsVO) {
        //分页信息
        PageHelper.startPage(goodsVO.getPagenum(),goodsVO.getPagesize());
        //查询
        List<Goods> goods = goodsMapper.selectAll(goodsVO);
        //分页查询后的信息
        PageInfo<Goods> goodsPageInfo = new PageInfo<>(goods);
        //返回数据
        return goodsPageInfo;
    }

}
