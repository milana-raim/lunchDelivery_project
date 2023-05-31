package ru.itis.yaylunch.dto.response;

import lombok.Data;
import org.apache.commons.io.monitor.FileEntry;
import ru.itis.yaylunch.models.PhotoEntity;

import java.sql.Blob;

@Data
public class DishResponse {

    private Long id;

    private String name;

    private Integer calories;

    private String ingredients;

    private Integer fat;

    private Integer protein;

    private Integer carbohydrate;

    private Integer price;

    private PhotoEntity photo;
}
