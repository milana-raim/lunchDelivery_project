package ru.itis.yaylunch.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itis.yaylunch.dto.forms.SignUpForm;
import ru.itis.yaylunch.mapper.AccountMapper;
import ru.itis.yaylunch.models.Account;
import ru.itis.yaylunch.models.Client;
import ru.itis.yaylunch.models.Restaurant;
import ru.itis.yaylunch.models.School;
import ru.itis.yaylunch.repositories.AccountRepository;
import ru.itis.yaylunch.repositories.ClientRepository;
import ru.itis.yaylunch.repositories.RestaurantRepository;
import ru.itis.yaylunch.repositories.SchoolRepository;
import ru.itis.yaylunch.service.SignUpService;

@Slf4j
@Service
@RequiredArgsConstructor
public class SignUpServiceImpl implements SignUpService {

    private final AccountRepository accountsRepository;
    private final SchoolRepository schoolRepository;
    private final RestaurantRepository restaurantRepository;
    private final ClientRepository clientRepository;
    private final PasswordEncoder passwordEncoder;
    private final AccountMapper accountMapper;

    @Override
    public void signUp(SignUpForm form) {
        Account account = accountMapper.toEntity(form);
        account.setPhone(form.getPhone());
        account.setPassword(passwordEncoder.encode(form.getPassword()));
        account.setState(Account.State.CONFIRMED);

        if (form.getRole().equals(Account.Role.RESTAURANT)) {
            Restaurant newRestaurant = Restaurant
                    .builder()
                    .account(account)
                    .name(form.getName())
                    .build();
            account.setRestaurant(newRestaurant);
        } else if (form.getRole().equals(Account.Role.SCHOOL)) {
            School newSchool = School
                    .builder()
                    .account(account)
                    .name(form.getName())
                    .build();
            account.setSchool(newSchool);
        } else {
            Client newCLint = Client
                    .builder()
                    .firstName(form.getFirstName())
                    .lastName(form.getLastName())
                    .account(account)
                    .build();
            account.setClient(newCLint);
        }
        System.out.println(account.getPhone());
        log.info(form.getPassword());
        log.info(account.toString());
        Account account1 = accountsRepository.save(account);
        log.info(account1.toString());
    }
}
