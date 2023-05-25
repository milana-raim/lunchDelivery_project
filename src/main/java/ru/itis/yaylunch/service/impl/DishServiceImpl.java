package ru.itis.yaylunch.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itis.yaylunch.dto.response.DishResponse;
import ru.itis.yaylunch.exceptions.DishNotFoundException;
import ru.itis.yaylunch.mapper.DishMapper;
import ru.itis.yaylunch.models.Dish;
import ru.itis.yaylunch.repositories.DishRepository;
import ru.itis.yaylunch.service.DishService;

import java.util.List;

@RequiredArgsConstructor
@Service
public class DishServiceImpl implements DishService {
    public final DishRepository dishRepository;

    public final DishMapper dishMapper;

    @Override
    public DishResponse get(Long id) {
        Dish dish = dishRepository.findById(id).orElseThrow(DishNotFoundException::new);
        return dishMapper.toResponse(dish);
    }

    @Override
    public List<DishResponse> getAll() {
        return dishMapper.toResponse(dishRepository.findAll());
    }

    @Override
    public List<DishResponse> getAllByRestaurant(Long restaurantId) {
        List<Dish> dishes = dishRepository.findAllByRestaurant_Id(restaurantId);
        System.out.println(dishes);
        System.out.println(dishes);
        System.out.println(dishes);
        System.out.println(dishes);
        System.out.println(dishes);
        return dishMapper.toResponse(dishes);
    }
}
