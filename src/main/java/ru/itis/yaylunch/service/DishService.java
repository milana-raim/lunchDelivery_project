package ru.itis.yaylunch.service;


import ru.itis.yaylunch.dto.response.DishResponse;
import ru.itis.yaylunch.models.Dish;

import java.util.List;

public interface DishService {
    DishResponse get(Long id);

    Dish getEntity(Long id);

    List<DishResponse> getAll();

    List<DishResponse> getAllByRestaurant(Long restaurantId);
}
