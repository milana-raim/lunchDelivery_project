package ru.itis.yaylunch.service;

import org.springframework.security.core.Authentication;
import ru.itis.yaylunch.dto.response.DeliveryResponse;

import java.util.List;

public interface DeliveryService {
    List<DeliveryResponse> getAll(Authentication authentication);
}
