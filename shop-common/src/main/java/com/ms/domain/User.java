package com.ms.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "shop_user")//实体类和数据表的对应关系
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//数据库Id自增长
    private Integer id;
    private String username;
    private String password;
    private String telephone;
}
