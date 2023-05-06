package ru.itis.yaylunch.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.yaylunch.models.Organization;

import java.util.Optional;

public interface OrganizationsRepository extends JpaRepository<Organization, Long> {
    Optional<Organization> findById(Long id);
}
