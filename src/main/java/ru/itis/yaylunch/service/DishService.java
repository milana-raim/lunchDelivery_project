package ru.itis.yaylunch.service;


import ru.itis.yaylunch.dto.request.NewDishRequest;
import ru.itis.yaylunch.dto.response.DishResponse;
import ru.itis.yaylunch.models.Dish;
import ru.itis.yaylunch.models.PhotoEntity;

import java.util.List;

public interface DishService {
    DishResponse get(Long id);

    Dish getEntity(Long id);

    List<DishResponse> getAll();

    List<DishResponse> getAllByRestaurant(Long restaurantId);

    void addDish(NewDishRequest dishRequest);

    List<DishResponse> getAllByRestaurantRole();

    PhotoEntity getImage(Long dishId);

    void deleteDish(Long dishId);
}
