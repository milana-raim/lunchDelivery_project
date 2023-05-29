package ru.itis.yaylunch.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "orders")
public class Order {

    public enum State {
        READY, CANCELLED, PAID, UNPAID, DELIVERED
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client")
    private Client client;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "order_dish",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "dish_id"))
    private List<Dish> dishes;

    @Enumerated(value = EnumType.STRING)
    private State state;

    @Column(name = "delivery_date")
    private LocalDateTime deliveryDate;

    @Column(name = "preference")
    private String preference;

    @ManyToOne
    @JoinColumn(name = "restaurant")
    private Restaurant restaurant;
}
