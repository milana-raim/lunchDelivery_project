package ru.itis.yaylunch.controllers.newer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.itis.yaylunch.dto.request.AddDishToOrderRequest;
import ru.itis.yaylunch.dto.request.OrderRequest;
import ru.itis.yaylunch.dto.response.OrderResponse;
import ru.itis.yaylunch.service.BasketService;
import ru.itis.yaylunch.service.OrderService;

import java.util.List;


@Controller
@RequestMapping("/basket")
@RequiredArgsConstructor
@Slf4j
public class BasketController {
    private final BasketService basketService;

    @GetMapping("/addDish")
    public String addDish(@RequestParam("dishId") Long dishId) {

        basketService.addDish(dishId);
        return "redirect:/basket";
    }

    @GetMapping("/deleteDish")
    public String deleteDish(@RequestParam("dishId") Long dishId) {

        basketService.deleteDish(dishId);
        return "redirect:/basket";
    }

    @GetMapping
    public String getBasket(Model model) {

        model.addAttribute("dishs", basketService.getByAccount().getDishes());
        System.out.println(basketService.getByAccount().getDishes());
        System.out.println(basketService.getByAccount());
        return "basket";
    }
}
