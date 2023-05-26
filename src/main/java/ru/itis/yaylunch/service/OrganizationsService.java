package ru.itis.yaylunch.service;


import ru.itis.yaylunch.dto.response.DishResponse;
import ru.itis.yaylunch.models.Organization;
import ru.itis.yaylunch.models.Restaurant;

import java.util.List;

public interface OrganizationsService {

    List<Restaurant> getAll();
    Restaurant findById(Long id);

}
