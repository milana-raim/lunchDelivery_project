package ru.itis.yaylunch.repositories.newer;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.yaylunch.models.newer.School;

import java.util.List;
import java.util.Optional;

public interface SchoolRepository extends JpaRepository<School, Long> {

    List<School> findAll();

    List<School> findAllByAddress_City(String city);

    Optional<School> findByName(String name);
}
