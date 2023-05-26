package ru.itis.yaylunch.controllers.newer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.itis.yaylunch.dto.request.SetRoleRestaurantRequest;
import ru.itis.yaylunch.dto.request.SetRoleSchoolRequest;
import ru.itis.yaylunch.service.AccountService;

@RequestMapping("/account")
@Slf4j
@Controller
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;

    @PostMapping("/set-role-school")
    public void setRoleSchool(SetRoleSchoolRequest setRoleSchoolRequest) {
        accountService.setRoleSchool(setRoleSchoolRequest);
    }

    @PostMapping("/set-role-restaurant")
    public void setRoleRestaurant(SetRoleRestaurantRequest setRoleRestaurantRequest) {
        accountService.setRoleRestaurant(setRoleRestaurantRequest);
    }
}
