package ru.itis.yaylunch.dto.request;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class NewDishRequest {
    private Long name;
    private Long calories;
    private Long ingredients;
    private Long fat;
    private Long protein;
    private Long carbohydrate;
    private Long price;
    private MultipartFile photo;
}
