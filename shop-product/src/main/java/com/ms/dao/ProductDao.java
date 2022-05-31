package com.ms.dao;

import com.ms.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

//继承中的的两个参数 第一个是数据库对应的实体类，第二个是实体类主键的类型
public interface ProductDao extends JpaRepository<Product,Integer> {
}
