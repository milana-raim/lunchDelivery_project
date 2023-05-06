package ru.itis.yaylunch.services;

import ru.itis.yaylunch.models.Account;

public interface SecurityService {
    Account getAuthorizedAccount();
}
