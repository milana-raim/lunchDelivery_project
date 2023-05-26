package ru.itis.yaylunch.dto.request;

import lombok.Data;

@Data
public class SetRoleRestaurantRequest {
    private String name;

    private String content;

    private Long addressId;

}
