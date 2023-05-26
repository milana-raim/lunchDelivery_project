package ru.itis.yaylunch.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itis.yaylunch.dto.response.DishResponse;
import ru.itis.yaylunch.exceptions.DishNotFoundException;
import ru.itis.yaylunch.mapper.DishMapper;
import ru.itis.yaylunch.models.Dish;
import ru.itis.yaylunch.models.Organization;
import ru.itis.yaylunch.models.Restaurant;
import ru.itis.yaylunch.repositories.DishRepository;
import ru.itis.yaylunch.repositories.OrganizationsRepository;
import ru.itis.yaylunch.repositories.RestaurantRepository;
import ru.itis.yaylunch.service.DishService;
import ru.itis.yaylunch.service.OrganizationsService;

import java.util.List;

@RequiredArgsConstructor
@Service
public class OrganizationsServiceImpl implements OrganizationsService {
    private final RestaurantRepository restaurantRepository;

    @Override
    public List<Restaurant> getAll() {
        return restaurantRepository.findAll();
    }

    @Override
    public Restaurant findById(Long id) {
        return restaurantRepository.getById(id);
    }
}
