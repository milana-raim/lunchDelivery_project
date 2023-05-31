package ru.itis.yaylunch.dto.response;

import lombok.Data;

@Data
public class SchoolResponse {

    private Long id;

    private String name;

    private String country;

    private String city;

    private String street;

    private String house;

    private String postalCode;
}
