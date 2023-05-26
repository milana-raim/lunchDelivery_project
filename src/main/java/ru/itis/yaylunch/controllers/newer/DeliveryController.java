package ru.itis.yaylunch.controllers.newer;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.itis.yaylunch.dto.response.DeliveryResponse;
import ru.itis.yaylunch.service.DeliveryService;

import java.util.List;

@Controller
@RequestMapping("delivery")
@RequiredArgsConstructor
public class DeliveryController {
    private final DeliveryService deliveryService;

    @PostMapping
    public String getDeliveries(Authentication authentication) {
        List<DeliveryResponse> deliveries = deliveryService.getAll(authentication);
        return "delivery";
    }
}
