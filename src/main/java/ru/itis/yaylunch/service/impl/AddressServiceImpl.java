package ru.itis.yaylunch.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.itis.yaylunch.exceptions.NotFoundException;
import ru.itis.yaylunch.models.Address;
import ru.itis.yaylunch.repositories.AddressRepository;
import ru.itis.yaylunch.service.AddressService;

@Slf4j
@RequiredArgsConstructor
@Service
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;

    @Override
    public Address getEntity(Long id) {
        return addressRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Model Not Found"));
    }
}
