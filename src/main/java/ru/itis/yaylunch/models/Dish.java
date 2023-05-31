package ru.itis.yaylunch.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Dish {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "calories")
    private Integer calories;

    @Column(name = "ingredients")
    private String ingredients;

    @Column(name = "fat")
    private Integer fat;

    @Column(name = "protein")
    private Integer protein;

    @Column(name = "carbohydrate")
    private Integer carbohydrate;

    @Column(name = "price")
    private Integer price;

    @ManyToOne
    @JoinColumn(name = "restaurant")
    private Restaurant restaurant;

    @ManyToMany
    private List<Basket> baskets;

    @ToString.Exclude
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "photo_id")
    private PhotoEntity photo;


}
