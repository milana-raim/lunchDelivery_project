package ru.itis.yaylunch.dto.forms;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.yaylunch.models.Account;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SignUpForm {
    @Size(min = 4, max = 20)
    @NotBlank
    private String firstName;

    @Size(min = 4, max = 20)
    @NotBlank
    private String lastName;

    @Size(min = 4, max = 20)
    @NotBlank
    private String name;

    @NotBlank
    private String password;

    @NotBlank
    private Account.Role role;

    @NotBlank
    private String phone;

    @Email
    @NotBlank
    private String email;
}
