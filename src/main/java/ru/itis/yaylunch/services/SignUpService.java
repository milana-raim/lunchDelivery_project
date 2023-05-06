package ru.itis.yaylunch.services;

import ru.itis.yaylunch.dto.AccountDto;
import ru.itis.yaylunch.dto.forms.SignUpForm;

public interface SignUpService {
    AccountDto signUp(SignUpForm signUpForm);

    void checkConfirm(String confirmCode);

}
