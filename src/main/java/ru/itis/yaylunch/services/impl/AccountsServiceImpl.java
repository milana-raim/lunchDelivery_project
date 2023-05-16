package ru.itis.yaylunch.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itis.yaylunch.dto.AccountDto;
import ru.itis.yaylunch.dto.mapper.AccountMapper;
import ru.itis.yaylunch.exceptions.AccountNotFoundException;
import ru.itis.yaylunch.models.newer.Account;
import ru.itis.yaylunch.repositories.AccountsRepository;
import ru.itis.yaylunch.services.AccountsService;

import java.util.List;
import java.util.function.Supplier;

@Service
@RequiredArgsConstructor
public class AccountsServiceImpl implements AccountsService {
    private final AccountsRepository accountsRepository;
    private final AccountMapper accountMapper;

    @Override
    public AccountDto getAccount(Long id) {
        Account account = accountsRepository.findById(id).orElseThrow((Supplier<RuntimeException>) ()
                -> new AccountNotFoundException("Account not found")
        );
        return accountMapper.toAccountDto(account);
    }

    @Override
    public List<AccountDto> getAllAccounts() {
        return accountMapper.toAccountDtoList(accountsRepository.findAll());
    }

    @Override
    public void deleteAccount(Long id) {
        Account account = accountsRepository.findById(id).orElseThrow((Supplier<RuntimeException>) ()
                -> new AccountNotFoundException("Account not found")
        );
        account.setState(Account.State.DELETED);

        accountsRepository.save(account);
    }

    @Override
    public List<AccountDto> getByOrganization(Long organizationId) {
        return accountMapper.toAccountDtoList(accountsRepository.findAllByOrganizationId(organizationId));
    }

    @Override
    public List<AccountDto> getAccounts() {
        return accountMapper.toAccountDtoList(accountsRepository.findAll());
    }
}
