package ru.itis.yaylunch.service;


import ru.itis.yaylunch.dto.forms.SignUpForm;

/**
 * 18.10.2021
 * 30. Java Web Application
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public interface SignUpService {
    void signUp(SignUpForm form);
}
