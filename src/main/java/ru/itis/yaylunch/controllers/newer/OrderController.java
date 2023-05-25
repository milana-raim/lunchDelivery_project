/*
package ru.itis.yaylunch.controllers.newer;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.yaylunch.service.OrderService;
import ru.itis.yaylunch.web.api.generated.OrderApi;
import ru.itis.yaylunch.web.dto.generated.OrderRequest;
import ru.itis.yaylunch.web.dto.generated.OrderResponse;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class OrderController implements OrderApi {
    private final OrderService orderService;

    @Override
    public ResponseEntity<List<OrderResponse>> orderGet(Long clintId) {
        return ResponseEntity.ok(orderService.getByClint(clintId));
    }

    @Override
    public ResponseEntity<Void> orderPatch(OrderRequest orderRequest) {
        return OrderApi.super.orderPatch(orderRequest);
    }


    @Override
    public ResponseEntity<Void> orderPost(OrderRequest orderRequest) {
        orderService.create(orderRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
*/
