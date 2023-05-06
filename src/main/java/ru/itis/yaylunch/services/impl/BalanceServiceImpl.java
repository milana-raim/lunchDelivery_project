package ru.itis.yaylunch.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itis.yaylunch.dto.AccountDto;
import ru.itis.yaylunch.dto.mapper.AccountMapper;
import ru.itis.yaylunch.exceptions.AccountNotFoundException;
import ru.itis.yaylunch.exceptions.CertificateNotFoundException;
import ru.itis.yaylunch.exceptions.LowBalanceException;
import ru.itis.yaylunch.models.Account;
import ru.itis.yaylunch.models.CertificateTemplate;
import ru.itis.yaylunch.repositories.AccountsRepository;
import ru.itis.yaylunch.repositories.CertificateTemplatesRepository;
import ru.itis.yaylunch.services.BalanceService;

import java.util.function.Supplier;

@Service
@RequiredArgsConstructor
public class BalanceServiceImpl implements BalanceService {
    private final AccountsRepository accountsRepository;
    private final CertificateTemplatesRepository certificateTemplatesRepository;
    private final AccountMapper accountMapper;

    @Override
    public Long getAccountBalance(Long accountId) {
        Account account = accountsRepository.findById(accountId).orElseThrow((Supplier<RuntimeException>) ()
                -> new AccountNotFoundException("Account not found")
        );
        return account.getBalance();
    }

    @Override
    public AccountDto addBalance(Long accountId, Integer amount) {
        Account account = accountsRepository.findById(accountId).orElseThrow((Supplier<RuntimeException>) ()
                -> new AccountNotFoundException("Account not found")
        );
        account.setBalance(account.getBalance() + amount);

        return accountMapper.toAccountDto(accountsRepository.save(account));
    }

    @Override
    public AccountDto purchaseOperation(Account account, Long certificateId){
        CertificateTemplate certificate = certificateTemplatesRepository.findById(certificateId).orElseThrow((Supplier<RuntimeException>) ()
                -> new CertificateNotFoundException("Certificate not found")
        );

        if (account.getBalance() >= certificate.getAmount()){
            account.setBalance(account.getBalance() - certificate.getAmount());
        } else {
            throw new LowBalanceException("Low balance");
        }

        return accountMapper.toAccountDto(accountsRepository.save(account));
    }
}
