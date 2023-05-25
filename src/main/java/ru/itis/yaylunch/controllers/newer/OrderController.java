package ru.itis.yaylunch.controllers.newer;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.yaylunch.dto.request.OrderRequest;
import ru.itis.yaylunch.dto.response.OrderResponse;
import ru.itis.yaylunch.service.OrderService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @GetMapping
    public ResponseEntity<List<OrderResponse>> orderGet(Long clintId) {
        return ResponseEntity.ok(orderService.getByClint(clintId));
    }

    public ResponseEntity<Void> orderPatch(Long id, OrderRequest orderRequest) {
        orderService.update(orderRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    public ResponseEntity<Long> orderPost(OrderRequest orderRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(orderService.create(orderRequest));
    }
}
