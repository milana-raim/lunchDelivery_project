package ru.itis.yaylunch.dto.request;

import lombok.Data;

@Data
public class SetRoleSchoolRequest {
    private String name;
    private String bankAccount;
    private Long addressId;
}
