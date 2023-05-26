package ru.itis.yaylunch.service;

import ru.itis.yaylunch.models.Account;

import java.util.Optional;

public interface AccountService {
    Optional<Account> getCurrentAccountFromSecurityContext();
}
