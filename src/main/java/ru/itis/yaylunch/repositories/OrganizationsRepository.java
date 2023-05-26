package ru.itis.yaylunch.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.yaylunch.models.Dish;
import ru.itis.yaylunch.models.Organization;
import ru.itis.yaylunch.models.Restaurant;

import java.util.List;

public interface OrganizationsRepository extends JpaRepository<Restaurant, Long> {

}
