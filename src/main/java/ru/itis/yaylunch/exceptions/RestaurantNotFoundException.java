package ru.itis.yaylunch.exceptions;

public class RestaurantNotFoundException extends NotFoundException {
    public RestaurantNotFoundException() {
        super("Restaurant Not Found");
    }
}
