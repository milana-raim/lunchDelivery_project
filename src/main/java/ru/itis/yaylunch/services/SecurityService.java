package ru.itis.yaylunch.services;

import ru.itis.yaylunch.models.newer.Account;

public interface SecurityService {
    Account getAuthorizedAccount();
}
