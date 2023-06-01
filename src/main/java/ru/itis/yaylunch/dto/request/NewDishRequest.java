package ru.itis.yaylunch.dto.request;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class NewDishRequest {
    private String name;
    private Integer calories;
    private String ingredients;
    private Integer fat;
    private Integer protein;
    private Integer carbohydrate;
    private Integer price;
    private MultipartFile photo;
}
