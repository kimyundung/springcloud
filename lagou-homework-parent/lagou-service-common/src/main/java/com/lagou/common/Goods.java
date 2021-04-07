package com.lagou.common;

import lombok.Data;

/**
 * 商品类
 */
@Data
public class Goods {

  private long id;
  private long cid;
  private long status;
  private String name;
  private double price;
  private String description;
  private String images;
  private long stock;
  private String type;

}
