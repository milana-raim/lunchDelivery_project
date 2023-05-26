package ru.itis.yaylunch.dto.request;

import lombok.Data;

@Data
public class AddDishToOrderRequest {
    private Long orderId;
    private Long dishId;
}
