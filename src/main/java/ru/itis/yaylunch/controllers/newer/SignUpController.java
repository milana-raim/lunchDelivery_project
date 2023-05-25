package ru.itis.yaylunch.controllers.newer;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.itis.yaylunch.dto.forms.SignUpForm;
import ru.itis.yaylunch.service.SignUpService;

import javax.validation.Valid;

@RequiredArgsConstructor
@Controller
@RequestMapping("/sign-up")
public class SignUpController {

    private final SignUpService signUpService;

    @GetMapping
    public String getSignUpPage(Authentication authentication, Model model) {

        if (authentication != null) {
            return "redirect:/";
        }

        model.addAttribute("signUpForm", new SignUpForm());
        return "sign_up";
    }

    @PostMapping
    public String signUp(@Valid SignUpForm form, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("signUpForm", form);
            return "sign_up";
        }
        signUpService.signUp(form);
        return "redirect:/sign-in";
    }
}
