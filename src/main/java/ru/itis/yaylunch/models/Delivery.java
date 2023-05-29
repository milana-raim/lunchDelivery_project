package ru.itis.yaylunch.models;

/*import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "delivery_date")
    private Date deliveryDate;

    @Column(name = "is_delivered")
    private Boolean isDelivered;

    @Column(name = "preference")
    private String preference;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "restaurant")
    private Restaurant restaurant;
}*/
