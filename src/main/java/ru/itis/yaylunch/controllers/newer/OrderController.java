package ru.itis.yaylunch.controllers.newer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.itis.yaylunch.dto.request.AddDishToOrderRequest;
import ru.itis.yaylunch.dto.request.NewOrderRequest;
import ru.itis.yaylunch.dto.request.OrderRequest;
import ru.itis.yaylunch.dto.response.OrderResponse;
import ru.itis.yaylunch.exceptions.AccountNotFoundException;
import ru.itis.yaylunch.models.Account;
import ru.itis.yaylunch.models.Order;
import ru.itis.yaylunch.service.AccountService;
import ru.itis.yaylunch.service.OrderService;

import java.util.List;


@Controller
@RequestMapping("/order")
@RequiredArgsConstructor
@Slf4j
public class OrderController {
    private final OrderService orderService;
    private final AccountService accountService;

    @PostMapping("/addDish")
    public void addDish(@RequestBody AddDishToOrderRequest request) {
        orderService.addDish(request);
    }

    @PostMapping("/setStatus/{order-id}")
    public String setStatus(@RequestParam String status,
                          @PathVariable(name = "order-id") Long orderId) {
        orderService.setStatus(orderId, status);
        return "redirect:/order/account";
    }

    @GetMapping("/account")
    public String getAccountOrders(Model model) {
        List<OrderResponse> orders = orderService.getAccountOrders();
        model.addAttribute("orders", orders);
        Account account = accountService.getCurrentAccountFromSecurityContext()
                .orElseThrow(AccountNotFoundException::new);
        model.addAttribute("user", account);
        return "orders";
    }

    @PostMapping("/new")
    @ResponseBody
    public ResponseEntity<Void> newOrder(Model model, NewOrderRequest newOrderRequest) {
        log.info("newOrderRequest".concat(newOrderRequest.toString()));
        orderService.orderingDishesFromBasket(newOrderRequest);
        return ResponseEntity.ok().build();
    }

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
