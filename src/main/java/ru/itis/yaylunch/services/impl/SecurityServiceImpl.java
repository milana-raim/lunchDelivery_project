package ru.itis.yaylunch.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import ru.itis.yaylunch.models.newer.Account;
import ru.itis.yaylunch.security.details.AccountUserDetails;
import ru.itis.yaylunch.services.SecurityService;

@Service
@RequiredArgsConstructor
public class SecurityServiceImpl implements SecurityService {
    @Override
    public Account getAuthorizedAccount() {
        Account account = ((AccountUserDetails) SecurityContextHolder.getContext().getAuthentication().getCredentials()).getAccount();

        return account;
    }
}
