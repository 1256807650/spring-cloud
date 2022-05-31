package com.ms.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//订单
@Entity(name = "shop_order")
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    //用户信息
    private Integer userId;
    private String username;
    //商品信息
    private Integer productId;
    private String productName;
    private Double productPrice;
    //购买数量
    private Integer number;

}
