package ru.itis.yaylunch.dto.request;

import lombok.Data;

import java.util.List;

@Data
public class OrderRequest {

    private Integer clientId;

    private List<Integer> dishesIds;
}
