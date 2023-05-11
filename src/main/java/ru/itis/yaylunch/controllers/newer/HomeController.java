package ru.itis.yaylunch.controllers.newer;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.yaylunch.dto.AccountDto;
import ru.itis.yaylunch.services.AccountsService;

import java.util.List;

@Controller
public class HomeController {
    @RequestMapping("/")
    public String hello(Model model) {
        return "menu";
    }
}
