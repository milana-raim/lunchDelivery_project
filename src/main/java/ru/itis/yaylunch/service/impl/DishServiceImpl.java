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
import ru.itis.yaylunch.models.PhotoEntity;
import ru.itis.yaylunch.models.Restaurant;
import ru.itis.yaylunch.repositories.DishRepository;
import ru.itis.yaylunch.service.AccountService;
import ru.itis.yaylunch.service.DishService;

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
        System.out.println("disssshes");
        dishes.forEach(dish -> System.out.println(dish.getPhoto() == null));
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
        Restaurant restaurant = account.getRestaurant();
        newDish.setRestaurant(restaurant);
        dishRepository.save(newDish);
    }

    @Override
    public List<DishResponse> getAllByRestaurantRole() {
        Account account = accountService.getCurrentAccountFromSecurityContext()
                .orElseThrow(AccountNotFoundException::new);
        return dishMapper.toResponse(dishRepository.findAllByRestaurant_Id(account.getRestaurant().getId()));
    }

    @Override
    public PhotoEntity getImage(Long dishId) {
        Dish dish = dishRepository.findById(dishId)
                .orElseThrow(DishNotFoundException::new);
        return dish.getPhoto();
    }

    @Override
    public void deleteDish(Long dishId) {
        Account account = accountService.getCurrentAccountFromSecurityContext()
                .orElseThrow(AccountNotFoundException::new);
        Dish dish = dishRepository.getById(dishId);
        if(dish.getRestaurant().getId().equals(account.getRestaurant().getId())){
            dishRepository.delete(dish);
        }

    }
}
