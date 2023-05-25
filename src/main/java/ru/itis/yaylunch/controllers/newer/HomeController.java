package ru.itis.yaylunch.controllers.newer;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping("/")
    public String hello(Authentication authentication, Model model) {
        return "menu";
    }
}
