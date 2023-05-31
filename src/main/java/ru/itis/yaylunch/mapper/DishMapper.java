package ru.itis.yaylunch.mapper;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.web.multipart.MultipartFile;
import ru.itis.yaylunch.dto.request.NewDishRequest;
import ru.itis.yaylunch.dto.response.DishResponse;
import ru.itis.yaylunch.models.Dish;
import ru.itis.yaylunch.models.PhotoEntity;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface DishMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "photo", target = "photo")
    DishResponse toResponse(Dish dish);

    List<DishResponse> toResponse(List<Dish> dishs);

    @Mapping(source = "newDishRequest", target = "photo", qualifiedByName = "photo")
    Dish toEntity(NewDishRequest newDishRequest);

    @SneakyThrows
    @Named("photo")
    default PhotoEntity locationToLocationDto(NewDishRequest newDishRequest) {
        if (newDishRequest.getPhoto() == null) {
            return null;
        }
        MultipartFile file = newDishRequest.getPhoto();
        System.out.println("fileinfo: ");
        System.out.println(file.getName());
        System.out.println(file.getSize());
        System.out.println(file.getContentType());
        return PhotoEntity
                .builder()
                .size(file.getSize())
                .type(file.getContentType())
                .name(file.getName())
                .bytes(file.getBytes())
                .build();

    }

}
