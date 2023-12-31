package ru.itis.yaylunch.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.yaylunch.models.Dish;

import java.util.List;

public interface DishRepository extends JpaRepository<Dish, Long> {

    List<Dish> findAllByOrderByCaloriesAsc();

    List<Dish> findAllByOrderByCaloriesDesc();

    List<Dish> findAllByOrderByFatDesc();

    List<Dish> findAllByOrderByFatAsc();

    List<Dish> findAllByOrderByPriceAsc();

    List<Dish> findAllByOrderByPriceDesc();

    List<Dish> findAllByOrderByCarbohydrateAsc();

    List<Dish> findAllByOrderByCarbohydrateDesc();

    List<Dish> findAllByOrderByProteinAsc();

    List<Dish> findAllByOrderByProteinDesc();

    List<Dish> findAllByRestaurant_Id(Long id);

}
