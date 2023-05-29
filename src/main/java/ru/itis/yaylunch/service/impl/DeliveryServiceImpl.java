package ru.itis.yaylunch.service.impl;

/*import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import ru.itis.yaylunch.dto.response.DeliveryResponse;
import ru.itis.yaylunch.mapper.DeliveryMapper;
import ru.itis.yaylunch.models.Account;
import ru.itis.yaylunch.repositories.DeliveryRepository;
import ru.itis.yaylunch.security.details.AccountUserDetails;
import ru.itis.yaylunch.service.DeliveryService;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class DeliveryServiceImpl implements DeliveryService {

    private final DeliveryRepository deliveryRepository;

    private final DeliveryMapper deliveryMapper;

    @Override
    public List<DeliveryResponse> getAll(Authentication authentication) {
        *//*if (authentication.getAuthorities().contains(Account.Role.RESTAURANT)) {
            AccountUserDetails userDetails = (AccountUserDetails) authentication.getDetails();
            return deliveryMapper.toResponse(deliveryRepository.findDeliveryByRestaurant_Id(userDetails.getId()));
        }
        if (authentication.getAuthorities().contains(Account.Role.SCHOOL)) {
            AccountUserDetails userDetails = (AccountUserDetails) authentication.getDetails();
            return deliveryMapper.toResponse(deliveryRepository.findDeliveryByS(userDetails.getId()));
        }*//*


        return new ArrayList<>();
    }
}*/
