package ru.itis.yaylunch.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.itis.yaylunch.dto.response.SchoolResponse;
import ru.itis.yaylunch.models.School;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SchoolMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(target = "country", source = "address.country")
    @Mapping(target = "city", source = "address.country")
    @Mapping(target = "street", source = "address.street")
    @Mapping(target = "house", source = "address.house")
    @Mapping(target = "postalCode", source = "address.postalCode")
    SchoolResponse toResponse(School school);

    List<SchoolResponse> toResponse(List<School> schools);
}
