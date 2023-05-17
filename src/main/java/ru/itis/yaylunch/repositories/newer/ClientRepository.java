package ru.itis.yaylunch.repositories.newer;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.yaylunch.models.newer.Account;
import ru.itis.yaylunch.models.newer.Client;

import java.util.List;
import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long> {

    Optional<Client> findById(Long id);

    Optional<Client> findClientByAccount_Id(Long id);

    Optional<Client> findClientByAccount_Email(String email);

    Optional<Client> findClientByAccount_Phone(String phone);
}
