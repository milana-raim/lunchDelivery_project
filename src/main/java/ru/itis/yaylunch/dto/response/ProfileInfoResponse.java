package ru.itis.yaylunch.dto.response;

import lombok.Data;
import ru.itis.yaylunch.models.Account;

@Data
public class ProfileInfoResponse {
    private String fullAccountName;

    private Account.Role role;
}
