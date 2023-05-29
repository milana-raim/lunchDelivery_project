package ru.itis.yaylunch.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.itis.yaylunch.dto.request.AddDishToOrderRequest;
import ru.itis.yaylunch.dto.request.OrderRequest;
import ru.itis.yaylunch.dto.response.OrderResponse;
import ru.itis.yaylunch.exceptions.AccountNotFoundException;
import ru.itis.yaylunch.exceptions.NotFoundException;
import ru.itis.yaylunch.mapper.OrderMapper;
import ru.itis.yaylunch.models.Account;
import ru.itis.yaylunch.models.Dish;
import ru.itis.yaylunch.models.Order;
import ru.itis.yaylunch.repositories.OrderRepository;
import ru.itis.yaylunch.service.AccountService;
import ru.itis.yaylunch.service.DishService;
import ru.itis.yaylunch.service.OrderService;

import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    private final OrderMapper orderMapper;

    private final AccountService accountService;

    private final DishService dishService;

    @Override
    public Long create(OrderRequest orderRequest) {

        return orderRepository.save(orderMapper.toEntity(orderRequest)).getId();
    }

    @Override
    public List<OrderResponse> getByClint(Long clintId) {
        return orderMapper.toResponse(orderRepository.findAllByClient_Account_Id(clintId));
    }

    @Override
    public void update(OrderRequest orderRequest) {

    }

    @Override
    public List<OrderResponse> getAccountOrders() {
        Account account = accountService.getCurrentAccountFromSecurityContext()
                .orElseThrow(AccountNotFoundException::new);
        if (account.getRole().equals(Account.Role.SCHOOL)) {
            log.info("received list orders for school");
            return orderMapper.toResponse(orderRepository.findAllByClientSchool_Account_Id(account.getId()));
        }
        if (account.getRole().equals(Account.Role.USER)) {
            log.info("received list orders for user");
            return orderMapper.toResponse(orderRepository.findAllByClient_Account_Id(account.getId()));
        }
        if (account.getRole().equals(Account.Role.RESTAURANT)) {
            log.info("received list orders for the restaurant");
            return orderMapper.toResponse(orderRepository.findAllByRestaurant_Account_Id(account.getId()));
        }
        return Collections.emptyList();
    }

    @Override
    public void addDish(AddDishToOrderRequest request) {
        Order order = orderRepository.findById(request.getOrderId())
                .orElseThrow(() -> new NotFoundException("Order not found"));
        Dish dish = dishService.getEntity(request.getDishId());
        order.getDishes().add(dish);
        orderRepository.save(order);
    }

    @Override
    public void setStatus(Long orderId, String status) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new NotFoundException("Order not found"));
        if (status.equals(Order.State.PAID.toString())) {
            order.setState(Order.State.PAID);
        } else if (status.equals(Order.State.UNPAID.toString())) {
            order.setState(Order.State.UNPAID);
        } else if (status.equals(Order.State.CANCELLED.toString())) {
            order.setState(Order.State.CANCELLED);
        } else if (status.equals(Order.State.READY.toString())) {
            order.setState(Order.State.READY);
        }
        orderRepository.save(order);
    }


}
