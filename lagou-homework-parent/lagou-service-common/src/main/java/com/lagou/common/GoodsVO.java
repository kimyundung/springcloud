package com.lagou.common;

import lombok.Data;

/**
 * 商品相关与页面传输数据用的类
 */
@Data
public class GoodsVO {
    private String name;
    private Integer cid;
    private Double startPrice;
    private Double endPrice;
    private Integer startStock;
    private Integer endStock;
    private Integer status;
    private Integer pagenum;
    private Integer pagesize;
}
