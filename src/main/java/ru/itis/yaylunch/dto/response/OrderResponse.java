package ru.itis.yaylunch.dto.response;

import lombok.Data;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class OrderResponse {

    public Long id;

    public Long clientId;

    public Long restaurantId;

    public String state;

    private LocalDateTime deliveryDate;

    private String preference;

    public List<DishResponse> dishes;
}
