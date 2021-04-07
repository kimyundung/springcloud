package com.lagou.common;

import lombok.Data;

import javax.persistence.Table;
import java.util.Date;
import java.util.List;

/**
 * 订单类
 */
@Data
public class Orders {

  private long id;
  private String ordernumber;
  private double orderprice;
  private Integer status;
  private Date createtime;

}
