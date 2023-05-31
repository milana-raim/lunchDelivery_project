package ru.itis.yaylunch.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import ru.itis.yaylunch.dto.forms.SignUpForm;
import ru.itis.yaylunch.dto.response.ProfileInfoResponse;
import ru.itis.yaylunch.models.Account;
import ru.itis.yaylunch.models.Client;

@Mapper(componentModel = "spring")
public interface AccountMapper {
    @Mapping(target = "password", ignore = true)
    @Mapping(source = "phone", target = "phone")
    Account toEntity(SignUpForm signUpForm);

    @Mapping(source = "account", target = "fullAccountName", qualifiedByName = "fullName")
    ProfileInfoResponse toProfileInfoResponse(Account account);

    @Named("fullName")
    default String getFullName(Account account) {
        switch (account.getRole()) {
            case SCHOOL -> {
                return account.getSchool().getName();
            }
            case RESTAURANT -> {
                return account.getRestaurant().getName();
            }
            case USER -> {
                Client client = account.getClient();
                return client.getFirstName().concat(" ").concat(client.getLastName());
            }
        }
        return "ROLE NOT DEFINED";
    }


}
