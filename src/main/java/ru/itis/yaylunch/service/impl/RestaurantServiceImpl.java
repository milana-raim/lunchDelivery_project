package ru.itis.yaylunch.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import ru.itis.yaylunch.exceptions.NotFoundException;
import ru.itis.yaylunch.exceptions.RestaurantNotFoundException;
import ru.itis.yaylunch.models.Restaurant;
import ru.itis.yaylunch.repositories.RestaurantRepository;
import ru.itis.yaylunch.service.RestaurantService;

@Service
@RequiredArgsConstructor
public class RestaurantServiceImpl implements RestaurantService {
    private final RestaurantRepository restaurantRepository;

    @Override
    public Restaurant save(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    @Override
    public Restaurant getById(Long restaurantId) {
        return restaurantRepository.findById(restaurantId)
                .orElseThrow(RestaurantNotFoundException::new);
    }
}
