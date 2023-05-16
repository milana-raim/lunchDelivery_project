package ru.itis.yaylunch.services;

import ru.itis.yaylunch.dto.AccountDto;
import ru.itis.yaylunch.models.newer.Account;

public interface BalanceService {
    Long getAccountBalance(Long accountId);

    AccountDto addBalance(Long accountId, Integer amount);

    AccountDto purchaseOperation(Account account, Long certificateId);
}
