package ru.itis.yaylunch.dto.forms;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.yaylunch.models.Account;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ProfileForm {

    private String firstName;

    private String lastName;

    private String name;

    private Account.Role role;

    private String phone;

    private String email;

    private String className;

    private Integer grade;

    private String clientSchoolName;

    private Long clientSchoolId;

    private String country;

    private String city;

    private String street;

    private String house;

    private String postalCode;

    private String content;
}
