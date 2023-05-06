package ru.itis.yaylunch.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itis.yaylunch.dto.AccountDto;
import ru.itis.yaylunch.dto.forms.SignUpForm;
import ru.itis.yaylunch.dto.mapper.AccountMapper;
import ru.itis.yaylunch.exceptions.AccountAlreadyExistsException;
import ru.itis.yaylunch.exceptions.AccountNotFoundException;
import ru.itis.yaylunch.models.Account;
import ru.itis.yaylunch.repositories.AccountsRepository;
import ru.itis.yaylunch.services.SignUpService;
import ru.itis.yaylunch.util.EmailUtil;

import java.util.Optional;
import java.util.UUID;
import java.util.function.Supplier;

@Service
@RequiredArgsConstructor
public class SignUpServiceImpl implements SignUpService {

    private final AccountsRepository accountsRepository;
    private final AccountMapper accountMapper;
    private final PasswordEncoder passwordEncoder;
//    private final EmailUtil emailUtil;

    @Override
    public AccountDto signUp(SignUpForm signUpForm) {
        Optional<Account> account = accountsRepository.findAccountByEmail(signUpForm.getEmail());
        if(account.isPresent()) {
            throw new AccountAlreadyExistsException("Cannot register new account because account with this email is already registered");
        } else {
            Account newAccount = Account.builder()
                    .firstName(signUpForm.getFirstName())
                    .lastName(signUpForm.getLastName())
                    .email(signUpForm.getEmail())
                    .password(passwordEncoder.encode(signUpForm.getPassword()))
                    .balance(0L)
                    .confirmCode(UUID.randomUUID().toString())
                    .state(Account.State.NOT_CONFIRMED)
                    .role(Account.Role.USER)
                    .build();

//            emailUtil.sendConfirmMail(newAccount.getEmail(), "Для завершения регистрации нажмите кнопку в письме", "confirmMail.ftlh", newAccount);

            return accountMapper.toAccountDto(accountsRepository.save(newAccount));
        }
    }

    @Override
    public void checkConfirm(String confirmCode) {
        Account account = accountsRepository.findAccountByConfirmCode(confirmCode).orElseThrow((Supplier<RuntimeException>) ()
                -> new AccountNotFoundException("Account not found")
        );
        if (account.getState().equals(Account.State.NOT_CONFIRMED)) {
            account.setState(Account.State.CONFIRMED);
            accountsRepository.save(account);
        }
    }
}

