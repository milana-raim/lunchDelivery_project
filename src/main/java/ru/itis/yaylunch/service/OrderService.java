package ru.itis.yaylunch.service;


import ru.itis.yaylunch.dto.request.OrderRequest;
import ru.itis.yaylunch.dto.response.OrderResponse;

import java.util.List;

public interface OrderService {
    Long create(OrderRequest orderRequest);

    List<OrderResponse> getByClint(Long clintId);

    void update(OrderRequest orderRequest);
}
