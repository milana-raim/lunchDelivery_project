package ru.itis.yaylunch.controllers.newer;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.itis.yaylunch.exceptions.AccountNotFoundException;
import ru.itis.yaylunch.models.Account;
import ru.itis.yaylunch.service.AccountService;

@Controller
@RequestMapping("/profile")
@RequiredArgsConstructor
public class ProfileController {

    private final AccountService accountService;

    @GetMapping
    public String getProfilePage(Authentication authentication, Model model) {
        Account account = accountService.getCurrentAccountFromSecurityContext()
                .orElseThrow(AccountNotFoundException::new);

        model.addAttribute("user", account);

        return "profile";
    }
}