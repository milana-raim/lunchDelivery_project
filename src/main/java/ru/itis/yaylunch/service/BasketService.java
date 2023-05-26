package ru.itis.yaylunch.service;


import ru.itis.yaylunch.dto.request.AddDishToOrderRequest;
import ru.itis.yaylunch.dto.request.OrderRequest;
import ru.itis.yaylunch.dto.response.OrderResponse;
import ru.itis.yaylunch.models.Basket;

import java.util.List;

public interface BasketService {
    void addDish(Long  dishId);
    Basket getByAccount();
}
