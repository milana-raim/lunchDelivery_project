package ru.itis.yaylunch.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.itis.yaylunch.dto.response.DishResponse;
import ru.itis.yaylunch.models.Dish;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DishMapper {

    @Mapping(source = "id", target = "id")
    DishResponse toResponse(Dish dish);

    List<DishResponse> toResponse(List<Dish> dishs);
}
