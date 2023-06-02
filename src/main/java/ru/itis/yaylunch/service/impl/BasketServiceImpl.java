package ru.itis.yaylunch.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.itis.yaylunch.dto.request.AddDishToOrderRequest;
import ru.itis.yaylunch.dto.request.OrderRequest;
import ru.itis.yaylunch.dto.response.OrderResponse;
import ru.itis.yaylunch.exceptions.AccountNotFoundException;
import ru.itis.yaylunch.exceptions.DifferentRestaurantException;
import ru.itis.yaylunch.exceptions.NotFoundException;
import ru.itis.yaylunch.mapper.OrderMapper;
import ru.itis.yaylunch.models.Account;
import ru.itis.yaylunch.models.Basket;
import ru.itis.yaylunch.models.Dish;
import ru.itis.yaylunch.models.Order;
import ru.itis.yaylunch.repositories.BasketRepository;
import ru.itis.yaylunch.repositories.DishRepository;
import ru.itis.yaylunch.repositories.OrderRepository;
import ru.itis.yaylunch.service.AccountService;
import ru.itis.yaylunch.service.BasketService;
import ru.itis.yaylunch.service.DishService;
import ru.itis.yaylunch.service.OrderService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Slf4j
public class BasketServiceImpl implements BasketService {

    private final AccountService accountService;
    private final BasketRepository basketRepository;
    private final DishRepository dishRepository;

    private final DishService dishService;

    @Override
    public void addDish(Long dishId) {
        Account account = accountService.getCurrentAccountFromSecurityContext()
                .orElseThrow(AccountNotFoundException::new);
        Optional<Basket> optionalBasket = basketRepository.findByAccount_Id(account.getId());
        Basket basket1;
        Dish dish = dishRepository.getById(dishId);
        if (optionalBasket.isPresent()) {
            basket1 = optionalBasket.get();
            List<Dish> dishes = basket1.getDishes();
            if (!dishes.isEmpty() && !dishes.get(dishes.size() - 1).getRestaurant().equals(dish.getRestaurant())) {
                throw new DifferentRestaurantException();
            }
            dishes.add(dish);
            basketRepository.save(basket1);
        } else {
            basket1 = Basket.builder()
                    .account(account)
                    .dishes(new ArrayList<Dish>())
                    .build();
            basket1.getDishes().add(dish);
            basketRepository.save(basket1);
        }

    }

    @Override
    public Basket getByAccount() {
        Account account = accountService.getCurrentAccountFromSecurityContext()
                .orElseThrow(AccountNotFoundException::new);

        Optional<Basket> basket = basketRepository.findByAccount_Id(account.getId());
        Basket basket1;

        if (basket.isPresent()) {
            basket1 = basket.get();
        } else {
            basket1 = Basket.builder()
                    .account(account)
                    .dishes(new ArrayList<>())
                    .build();
        }

        return basket1;
    }

    @Override
    public void deleteDish(Long dishId) {
        Account account = accountService.getCurrentAccountFromSecurityContext()
                .orElseThrow(AccountNotFoundException::new);
        Optional<Basket> basket = basketRepository.findByAccount_Id(account.getId());
        Basket basket1;
        Dish dish = dishRepository.getById(dishId);
        if (basket.isPresent()) {
            basket1 = basket.get();
            basket1.getDishes().remove(dish);
            basketRepository.save(basket1);
        }

    }

    @Override
    public void clearBasket(Long id) {
        Basket basket = basketRepository.getById(id);
        basket.setDishes(new ArrayList<>());
        basketRepository.save(basket);
    }
}
