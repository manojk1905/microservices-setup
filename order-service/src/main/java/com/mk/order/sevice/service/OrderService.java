package com.mk.order.sevice.service;

import com.mk.order.sevice.dao.OrderRepository;
import com.mk.order.sevice.entity.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Orders saveOrder(Orders order){
        return orderRepository.save(order);
    }

    public Orders getOrder(Long orderId) {
        return orderRepository.findById(orderId).get();
    }


}
