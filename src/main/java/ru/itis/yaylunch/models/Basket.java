package ru.itis.yaylunch.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 * @author Daniil Korotaev
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Data
public class Basket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "account_id")
    private Account account;


    @ManyToMany
    private List<Dish> dishes;

}
