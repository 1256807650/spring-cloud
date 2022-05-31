package com.ms.service.impl;

import com.ms.dao.ProductDao;
import com.ms.domain.Product;
import com.ms.service.ProductService;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductDao productDao;
    ProductServiceImpl(ProductDao productDao){
        this.productDao=productDao;
    }
    @Override
    public Product findById(Integer id) {
        return productDao.findById(id).get();
    }
}
