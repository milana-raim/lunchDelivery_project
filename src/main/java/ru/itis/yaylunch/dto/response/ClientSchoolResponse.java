package ru.itis.yaylunch.dto.response;

import lombok.Data;
import ru.itis.yaylunch.models.Account;

@Data
public class ClientSchoolResponse {

    private String firstName;

    private String lastName;

    private String className;

    private Integer grade;

}
