package ru.itis.yaylunch.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.yaylunch.models.CertificateInstance;

public interface CertificateInstancesRepository extends JpaRepository<CertificateInstance, Long> {
}
