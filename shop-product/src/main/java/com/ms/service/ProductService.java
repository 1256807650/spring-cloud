package com.ms.service;

import com.ms.domain.Product;
import org.springframework.stereotype.Service;

public interface ProductService {
    Product findById(Integer id);
}
