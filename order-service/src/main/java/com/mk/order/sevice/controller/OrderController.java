package com.mk.order.sevice.controller;

import com.mk.order.sevice.entity.Orders;
import com.mk.order.sevice.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("save")
    public Orders saveOrder(@RequestBody Orders order){
       log.info("Saving order details");
       return orderService.saveOrder(order);
    }

    @GetMapping("/{orderId}")
    public Orders getOrder(@PathVariable("orderId") Long orderId){
        log.info("Get order details for orderId: {}", orderId);
        return orderService.getOrder(orderId);
    }
}
