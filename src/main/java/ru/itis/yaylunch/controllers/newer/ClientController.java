package ru.itis.yaylunch.controllers.newer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.itis.yaylunch.service.ClientService;

@Controller
@RequestMapping("/clients")
@RequiredArgsConstructor
@Slf4j
public class ClientController {
    private final ClientService clientService;
    @GetMapping
    public String getSchoolClients(Model model) {

        model.addAttribute("clients", clientService.getAllBySchool());
        return "clients";
    }
}
