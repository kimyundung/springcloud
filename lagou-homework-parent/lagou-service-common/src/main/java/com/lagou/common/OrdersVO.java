package com.lagou.common;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 订单相关与页面传输数据用的类
 */
@Data
public class OrdersVO {
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endTime;
    private Integer status;
    private Integer pagenum;
    private Integer pagesize;
}
