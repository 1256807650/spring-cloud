package com.ms.service.impl;

import com.ms.dao.OrderDao;
import com.ms.domain.Order;
import com.ms.service.OrderService;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderDao orderDao;
    OrderServiceImpl(OrderDao orderDao){
        this.orderDao=orderDao;
    }
    @Override
    public Order createOrder(Order order) {
        return orderDao.save(order);
    }
}
