package ru.itis.yaylunch.exceptions;

public class PhotoNotFoundException extends NotFoundException {
    public PhotoNotFoundException() {
        super("Photo Not Found");
    }
}
