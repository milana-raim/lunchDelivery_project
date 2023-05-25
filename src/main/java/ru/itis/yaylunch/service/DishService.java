package ru.itis.yaylunch.service;


import ru.itis.yaylunch.dto.response.DishResponse;

import java.util.List;

public interface DishService {
    DishResponse get(Long id);

    List<DishResponse> getAll();

    List<DishResponse> getAllByRestaurant(Long restaurantId);
}
