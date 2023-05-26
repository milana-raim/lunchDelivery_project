package ru.itis.yaylunch.controllers.newer;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sign-in")
public class SignInController {

    @GetMapping
    public String getSignInPage(Authentication authentication) {
        if (authentication != null) {
            return "redirect:/organizations";
        }

        return "sign_in";
    }
}