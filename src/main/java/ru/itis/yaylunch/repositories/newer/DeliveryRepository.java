package ru.itis.yaylunch.repositories.newer;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.yaylunch.models.newer.Delivery;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

public interface DeliveryRepository extends JpaRepository<Delivery, Long> {

    Optional<Delivery> findById(Long id);

    Optional<Delivery> findDeliveryByOrder_Id(Long id);

    List<Delivery> findAllByDeliveryDate(Date date);

    Optional<Delivery> findDeliveryByRestaurant_Id(Long id);

    Optional<Delivery> findDeliveryByRestaurant_IdAndDeliveryDate(Long id, Date date);

}