package ru.itis.yaylunch.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.yaylunch.models.Order;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {

    Optional<Order> findById(Long id);

    List<Order> findAllByClient_Id(Long id);

    Optional<Order> findByDelivery_Id(Long id);

    List<Order> findAllByDelivery_Restaurant_Id(Long id);

    List<Order> findAllByDelivery_Restaurant_Account_Id(Long id);
    List<Order> findAllByClientSchoolId(Long schoolId);

}
