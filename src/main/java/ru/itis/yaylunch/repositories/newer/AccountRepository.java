package ru.itis.yaylunch.repositories.newer;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.yaylunch.models.newer.Account;
import ru.itis.yaylunch.models.newer.Client;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {

    Optional<Account> findAccountByEmail(String email);

    Optional<Account> findAccountByPhone(String phone);

    Optional<Account> findAccountByConfirmCode(String confirmCode);
}
