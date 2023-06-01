package ru.itis.yaylunch.controllers.newer;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.yaylunch.dto.request.NewDishRequest;
import ru.itis.yaylunch.dto.response.DishResponse;
import ru.itis.yaylunch.models.PhotoEntity;
import ru.itis.yaylunch.service.DishService;

import java.util.Base64;
import java.util.List;


@Controller
@RequiredArgsConstructor
@RequestMapping("/dish")
public class DishController {
    private final DishService dishService;

    @GetMapping
    public String dishGet(Model model) {
        List<DishResponse> dishes = dishService.getAllByRestaurantRole();
        model.addAttribute("dishsList", dishes);
        return "dishs_rest";
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

    @GetMapping("/delete")
    public String deleteDish(@RequestParam("dishId") Long dishId) {

        dishService.deleteDish(dishId);
        return "redirect:/dish";
    }
}
