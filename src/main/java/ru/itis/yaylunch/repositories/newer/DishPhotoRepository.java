package ru.itis.yaylunch.repositories.newer;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.yaylunch.models.newer.DishPhoto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface DishPhotoRepository extends JpaRepository<DishPhoto, Long> {

    Optional<DishPhoto> findByPhotoId(String photoId);

    List<DishPhoto> findByDish_Id(Long dishId);

}
