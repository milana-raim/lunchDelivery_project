package ru.itis.yaylunch.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.yaylunch.models.Order;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findAllByClient_Account_Id(Long id);

    List<Order> findAllByClient_School_Account_Id(Long schoolId);

    List<Order> findAllByRestaurant_Account_Id(Long restaurantId);

}
