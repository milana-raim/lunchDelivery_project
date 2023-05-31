package ru.itis.yaylunch.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.itis.yaylunch.dto.forms.SignUpForm;
import ru.itis.yaylunch.dto.response.ClientSchoolResponse;
import ru.itis.yaylunch.models.Account;
import ru.itis.yaylunch.models.Client;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientMapper {
    ClientSchoolResponse toResponse(Client client);

    List<ClientSchoolResponse> toResponse(List<Client> client);
}
