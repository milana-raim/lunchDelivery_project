package ru.itis.yaylunch.controllers.newer;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.itis.yaylunch.dto.forms.ProfileForm;
import ru.itis.yaylunch.dto.forms.SignUpForm;
import ru.itis.yaylunch.dto.response.ProfileInfoResponse;
import ru.itis.yaylunch.exceptions.AccountNotFoundException;
import ru.itis.yaylunch.models.Account;
import ru.itis.yaylunch.service.AccountService;
import ru.itis.yaylunch.service.SchoolService;

import javax.validation.Valid;

@Controller
@RequestMapping("/profile")
@RequiredArgsConstructor
public class ProfileController {

    private final AccountService accountService;

    private final SchoolService schoolService;

    @GetMapping
    public String getProfilePage(Authentication authentication, Model model) {
        ProfileForm profileForm = accountService.getCurrentProfileInfoResponse();
        model.addAttribute("user", profileForm);
        model.addAttribute("schools",schoolService.getAll());

        return "profile";
    }

    @PostMapping
    public String updateProfilePage(ProfileForm form, Authentication authentication, Model model) {
        accountService.updateProfile(form);
        ProfileForm profileForm = accountService.getCurrentProfileInfoResponse();
        model.addAttribute("user",profileForm);
        model.addAttribute("schools",schoolService.getAll());
        return "profile";
    }
}