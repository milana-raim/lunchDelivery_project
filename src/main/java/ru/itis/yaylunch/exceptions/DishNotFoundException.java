package ru.itis.yaylunch.exceptions;

public class DishNotFoundException extends NotFoundException {
    public DishNotFoundException() {
        super("Dish Not Found Exception");
    }
}
