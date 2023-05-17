package ru.itis.yaylunch.repositories.newer;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.yaylunch.models.newer.Restaurant;

import java.util.List;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

    List<Restaurant> findAll();
    List<Restaurant> findAllByAddress_City(String city);

}
