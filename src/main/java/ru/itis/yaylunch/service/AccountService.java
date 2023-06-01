package ru.itis.yaylunch.service;

import ru.itis.yaylunch.dto.forms.ProfileForm;
import ru.itis.yaylunch.dto.request.SetRoleRestaurantRequest;
import ru.itis.yaylunch.dto.request.SetRoleSchoolRequest;
import ru.itis.yaylunch.dto.response.ProfileInfoResponse;
import ru.itis.yaylunch.models.Account;

import java.util.Optional;

public interface AccountService {
    Optional<Account> getCurrentAccountFromSecurityContext();

    void setRoleSchool(SetRoleSchoolRequest setRoleSchoolRequest);

    void setRoleRestaurant(SetRoleRestaurantRequest setRoleRestaurantRequest);

    ProfileForm getCurrentProfileInfoResponse();

    void updateProfile(ProfileForm form);

    void save(Account account);
}
