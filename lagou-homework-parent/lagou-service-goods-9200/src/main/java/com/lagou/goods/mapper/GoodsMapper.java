package com.lagou.goods.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lagou.common.Goods;
import com.lagou.common.GoodsVO;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface GoodsMapper extends BaseMapper<Goods> {
    /**
     * 条件查询商品
     * @param goodsVO
     * @return
     */
    public List<Goods> selectAll(GoodsVO goodsVO);
}
