package ru.itis.yaylunch.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.yaylunch.models.DishPhoto;

import java.util.List;
import java.util.Optional;

public interface DishPhotoRepository extends JpaRepository<DishPhoto, Long> {

    Optional<DishPhoto> findByPhotoId(String photoId);

    List<DishPhoto> findByDish_Id(Long dishId);

}
