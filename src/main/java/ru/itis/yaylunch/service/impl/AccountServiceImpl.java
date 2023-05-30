package ru.itis.yaylunch.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import ru.itis.yaylunch.dto.request.SetRoleRestaurantRequest;
import ru.itis.yaylunch.dto.request.SetRoleSchoolRequest;
import ru.itis.yaylunch.dto.response.ProfileInfoResponse;
import ru.itis.yaylunch.exceptions.AccountNotFoundException;
import ru.itis.yaylunch.mapper.AccountMapper;
import ru.itis.yaylunch.models.Account;
import ru.itis.yaylunch.models.Restaurant;
import ru.itis.yaylunch.models.School;
import ru.itis.yaylunch.repositories.AccountRepository;
import ru.itis.yaylunch.service.AccountService;
import ru.itis.yaylunch.service.AddressService;
import ru.itis.yaylunch.service.RestaurantService;
import ru.itis.yaylunch.service.SchoolService;

import java.util.Optional;

import static ru.itis.yaylunch.models.Account.Role.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final AddressService addressService;
    private final SchoolService schoolService;
    private final RestaurantService restaurantService;
    private final AccountMapper accountMapper;

    @Override
    public Optional<Account> getCurrentAccountFromSecurityContext() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        username = principal.toString();
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        }
        log.info("getCurrentAccountFromSecurityContext for user with principal {}", username);
        return accountRepository.findAccountByEmail(username);
    }

    @Override
    public void setRoleSchool(SetRoleSchoolRequest setRoleSchoolRequest) {
        Account account = getCurrentAccountFromSecurityContext().get();
        account.setRole(SCHOOL);

        School newSchool = School.builder()
                .account(account)
                .address(addressService.getEntity(setRoleSchoolRequest.getAddressId()))
                .bankAccount(setRoleSchoolRequest.getBankAccount())
                .name(setRoleSchoolRequest.getName())
                .build();

        newSchool = schoolService.save(newSchool);
        account.setSchool(newSchool);

        accountRepository.save(account);
    }

    @Override
    public void setRoleRestaurant(SetRoleRestaurantRequest setRoleRestaurantRequest) {
        Account account = getCurrentAccountFromSecurityContext().get();
        account.setRole(RESTAURANT);

        Restaurant newRestaurant = Restaurant
                .builder()
                .content(setRoleRestaurantRequest.getContent())
                .address(addressService.getEntity(setRoleRestaurantRequest.getAddressId()))
                .name(setRoleRestaurantRequest.getName())
                .build();

        newRestaurant = restaurantService.save(newRestaurant);
        account.setRestaurants(newRestaurant);

        accountRepository.save(account);
    }

    @Override
    public ProfileInfoResponse getCurrentProfileInfoResponse() {
        Account account = getCurrentAccountFromSecurityContext()
                .orElseThrow(AccountNotFoundException::new);

        return accountMapper.toProfileInfoResponse(account);
    }
}
