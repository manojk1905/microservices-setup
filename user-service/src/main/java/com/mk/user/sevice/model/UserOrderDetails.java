package com.mk.user.sevice.model;

import com.mk.user.sevice.entity.User;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserOrderDetails {
    private User user;
    private Order order;
}
