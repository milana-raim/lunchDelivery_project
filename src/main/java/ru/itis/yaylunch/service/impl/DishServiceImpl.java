package ru.itis.yaylunch.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itis.yaylunch.dto.request.NewDishRequest;
import ru.itis.yaylunch.dto.response.DishResponse;
import ru.itis.yaylunch.exceptions.AccountNotFoundException;
import ru.itis.yaylunch.exceptions.DishNotFoundException;
import ru.itis.yaylunch.exceptions.ForbiddenException;
import ru.itis.yaylunch.exceptions.NotFoundException;
import ru.itis.yaylunch.mapper.DishMapper;
import ru.itis.yaylunch.models.Account;
import ru.itis.yaylunch.models.Dish;
import ru.itis.yaylunch.models.Restaurant;
import ru.itis.yaylunch.repositories.DishRepository;
import ru.itis.yaylunch.service.AccountService;
import ru.itis.yaylunch.service.DishService;
import ru.itis.yaylunch.service.RestaurantService;

import java.nio.channels.AcceptPendingException;
import java.util.List;

@RequiredArgsConstructor
@Service
public class DishServiceImpl implements DishService {

    private final DishRepository dishRepository;

    private final DishMapper dishMapper;

    private final AccountService accountService;

    @Override
    public DishResponse get(Long id) {
        Dish dish = dishRepository.findById(id).orElseThrow(DishNotFoundException::new);
        return dishMapper.toResponse(dish);
    }

    @Override
    public Dish getEntity(Long id) {
        return dishRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Dish not found"));
    }

    @Override
    public List<DishResponse> getAll() {
        return dishMapper.toResponse(dishRepository.findAll());
    }

    @Override
    public List<DishResponse> getAllByRestaurant(Long restaurantId) {
        List<Dish> dishes = dishRepository.findAllByRestaurant_Id(restaurantId);
        return dishMapper.toResponse(dishes);
    }

    @Override
    public void addDish(NewDishRequest newDishRequest) {
        Dish newDish = dishMapper.toEntity(newDishRequest);
        Account account = accountService.getCurrentAccountFromSecurityContext()
                .orElseThrow(AccountNotFoundException::new);
        if (!account.getRole().equals(Account.Role.RESTAURANT)) {
            throw new ForbiddenException("");
        }
        Restaurant restaurant = account.getRestaurants();
        newDish.setRestaurant(restaurant);
        dishRepository.save(newDish);
    }
}
