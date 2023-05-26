package ru.itis.yaylunch.service;


import org.springframework.security.core.Authentication;
import ru.itis.yaylunch.dto.request.AddDishToOrderRequest;
import ru.itis.yaylunch.dto.request.OrderRequest;
import ru.itis.yaylunch.dto.response.OrderResponse;

import java.util.List;

public interface OrderService {
    Long create(OrderRequest orderRequest);

    List<OrderResponse> getByClint(Long clintId);

    void update(OrderRequest orderRequest);

    List<OrderResponse> getAccountOrders();

    void addDish(AddDishToOrderRequest request);

    void setStatus(Long orderId, String status);
}
