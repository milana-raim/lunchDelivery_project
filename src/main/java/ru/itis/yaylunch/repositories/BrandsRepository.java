package ru.itis.yaylunch.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.yaylunch.models.Brand;

public interface BrandsRepository extends JpaRepository<Brand, Long> {
}
