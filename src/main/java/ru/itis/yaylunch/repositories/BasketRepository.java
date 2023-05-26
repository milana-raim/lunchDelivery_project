package ru.itis.yaylunch.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.yaylunch.models.Basket;
import ru.itis.yaylunch.models.Restaurant;

import java.util.List;
import java.util.Optional;

public interface BasketRepository extends JpaRepository<Basket, Long> {
    Optional<Basket> findByAccount_Id(Long id);

}
