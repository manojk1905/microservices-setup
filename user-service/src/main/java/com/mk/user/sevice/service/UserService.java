package com.mk.user.sevice.service;

import com.mk.user.sevice.entity.User;
import com.mk.user.sevice.model.UserOrderDetails;
import com.mk.user.sevice.dao.UserRepository;
import com.mk.user.sevice.model.Order;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user){
        return userRepository.save(user);
    }

    public User getUserOrder(Long userId) {
        return userRepository.findById(userId).get();
    }


}
