package com.mk.user.sevice.controller;

import com.mk.user.sevice.entity.User;
import com.mk.user.sevice.model.Order;
import com.mk.user.sevice.model.UserOrderDetails;
import com.mk.user.sevice.service.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("save")
    public User saveUser(@RequestBody User user){
       log.info("Saving user details");
       return userService.saveUser(user);
    }

    @GetMapping()
    @CircuitBreaker(name="order-service", fallbackMethod = "getDefaultOrder")
    public Order getUser(){
        log.info("Get user details for userId: {}");
        //User user =  userService.getUserOrder(userId);
        return  restTemplate.getForObject("http://localhost:9002/order/1", Order.class);
    }

    public Order getDefaultOrder(Exception exception){
        return new Order();
    }
}
