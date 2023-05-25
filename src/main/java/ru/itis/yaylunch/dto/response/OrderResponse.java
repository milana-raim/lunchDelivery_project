package ru.itis.yaylunch.dto.response;

import lombok.Data;

@Data
public class OrderResponse {

    public Integer clientId;

    public Integer deliveryId;

    public String state;
}
