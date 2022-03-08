package com.mk.user.sevice.model;

import lombok.*;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private Integer items;
    private String details;
}
