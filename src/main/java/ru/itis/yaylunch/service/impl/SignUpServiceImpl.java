package ru.itis.yaylunch.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itis.yaylunch.dto.forms.SignUpForm;
import ru.itis.yaylunch.models.Account;
import ru.itis.yaylunch.repositories.AccountRepository;
import ru.itis.yaylunch.service.SignUpService;

import java.util.Locale;

@Slf4j
@Service
@RequiredArgsConstructor
public class SignUpServiceImpl implements SignUpService {

    private final AccountRepository accountsRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void signUp(SignUpForm form) {
        Account account = Account.builder()
                .email(form.getEmail().toLowerCase(Locale.ROOT))
                .password(passwordEncoder.encode(form.getPassword()))
                .role(Account.Role.USER)
                .state(Account.State.NOT_CONFIRMED)
                .build();

        log.info(form.getPassword());
        log.info(account.toString());
        Account account1 = accountsRepository.save(account);
        log.info(account1.toString());
    }
}
