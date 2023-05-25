package ru.itis.yaylunch.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.yaylunch.models.Client;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long> {

    Optional<Client> findById(Long id);

    Optional<Client> findClientByAccount_Id(Long id);

    Optional<Client> findClientByAccount_Email(String email);

    Optional<Client> findClientByAccount_Phone(String phone);
}
