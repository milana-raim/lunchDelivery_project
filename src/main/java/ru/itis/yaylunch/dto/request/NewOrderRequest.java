package ru.itis.yaylunch.dto.request;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class NewOrderRequest {
    public String date;
    private String preference;
}
