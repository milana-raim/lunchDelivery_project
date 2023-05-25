package ru.itis.yaylunch.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itis.yaylunch.dto.request.OrderRequest;
import ru.itis.yaylunch.dto.response.OrderResponse;
import ru.itis.yaylunch.mapper.OrderMapper;
import ru.itis.yaylunch.repositories.OrderRepository;
import ru.itis.yaylunch.service.OrderService;

import java.util.List;

@RequiredArgsConstructor
@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    private final OrderMapper orderMapper;

    @Override
    public Long create(OrderRequest orderRequest) {
        return orderRepository.save(orderMapper.toEntity(orderRequest)).getId();
    }

    @Override
    public List<OrderResponse> getByClint(Long clintId) {
        return orderMapper.toResponse(orderRepository.findAllByClient_Id(clintId));
    }

    @Override
    public void update(OrderRequest orderRequest) {

    }
}
