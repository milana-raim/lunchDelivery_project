package ru.itis.yaylunch.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import ru.itis.yaylunch.dto.request.NewDishRequest;
import ru.itis.yaylunch.dto.response.DishResponse;
import ru.itis.yaylunch.models.Dish;
import ru.itis.yaylunch.models.DishPhoto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DishMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "dish", target = "photo", qualifiedByName = "photo")
    DishResponse toResponse(Dish dish);

    List<DishResponse> toResponse(List<Dish> dishs);

    @Named("photo")
    default byte[] locationToLocationDto(Dish dish) {
        List<DishPhoto> photos = dish.getPhotos();
        if (photos.isEmpty()) {
            return null;
        }
        return photos.get(0).getImage();
    }

    Dish toEntity(NewDishRequest newDishRequest);
}
