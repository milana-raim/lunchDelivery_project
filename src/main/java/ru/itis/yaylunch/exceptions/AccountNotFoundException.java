package ru.itis.yaylunch.exceptions;

public class AccountNotFoundException extends NotFoundException {

    public AccountNotFoundException() {
        super("Account Not Found");
    }

}
