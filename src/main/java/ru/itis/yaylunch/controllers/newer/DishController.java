package ru.itis.yaylunch.controllers.newer;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.itis.yaylunch.dto.request.NewDishRequest;
import ru.itis.yaylunch.dto.response.DishResponse;
import ru.itis.yaylunch.service.DishService;

import java.util.List;


@Controller
@RequiredArgsConstructor
@RequestMapping("/dish")
public class DishController {
    private final DishService dishService;

    @GetMapping("/{restaurant-id}")
    public String dishGet(@PathVariable(name = "restaurant-id") Long restaurantId, Model model) {
        List<DishResponse> dishes = dishService.getAllByRestaurant(restaurantId);
        model.addAttribute("dishes", dishes);
        return "products";
    }

    @GetMapping("/new")
    public String addDish() {
        return "add_dish";
    }
    @PostMapping("/new")
    public String addDish(NewDishRequest dishRequest) {
        dishService.addDish(dishRequest);
        return "add_dish";
    }
}
