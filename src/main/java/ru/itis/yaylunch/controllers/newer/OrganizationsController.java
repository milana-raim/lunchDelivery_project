package ru.itis.yaylunch.controllers.newer;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.itis.yaylunch.models.Restaurant;
import ru.itis.yaylunch.service.DishService;
import ru.itis.yaylunch.service.OrganizationsService;

@Controller
@RequiredArgsConstructor
public class OrganizationsController {
    private final OrganizationsService organizationsService;
    private final DishService dishService;

    @RequestMapping("/organizations")
    public String hello(Authentication authentication, Model model) {
        model.addAttribute("restList", organizationsService.getAll());
        System.out.println(organizationsService.getAll());

        return "organizations";
    }

    @RequestMapping("/organizations/{orgId}")
    public String hello(Authentication authentication, Model model, @PathVariable("orgId") Long orgId) {
        model.addAttribute("dishsList", dishService.getAllByRestaurant(orgId));

        return "dishs";
    }
}
