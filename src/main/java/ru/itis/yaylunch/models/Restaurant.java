package ru.itis.yaylunch.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "account")
    private Account account;

    @ManyToOne
    @JoinColumn(name = "address")
    private Address address;

    @OneToMany(mappedBy = "restaurant")
    @JsonManagedReference
    private List<Delivery> deliveries;

    @OneToMany(mappedBy = "restaurant")
    @JsonManagedReference
    private List<Dish> dishRespons;
}
