package ru.itis.yaylunch.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.yaylunch.models.PhotoEntity;

public interface PhotoRepository extends JpaRepository<PhotoEntity, Long> {

}

