package ru.itis.yaylunch.mapper;

import org.mapstruct.Mapper;
import ru.itis.yaylunch.dto.request.OrderRequest;
import ru.itis.yaylunch.dto.response.OrderResponse;
import ru.itis.yaylunch.models.Order;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    Order toEntity(OrderRequest orderRequest);

    List<OrderResponse> toResponse(List<Order> orders);
}
