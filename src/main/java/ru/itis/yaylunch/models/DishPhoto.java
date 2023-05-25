package ru.itis.yaylunch.models;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
@ToString
@Table(name = "dish_photos")
public class DishPhoto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "photo_id")
    String photoId;

    @ManyToOne
    @JoinColumn(name = "dish")
    private Dish dish;
}
