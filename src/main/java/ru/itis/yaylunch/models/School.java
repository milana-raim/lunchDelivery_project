package ru.itis.yaylunch.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "bank_account")
    private String bankAccount;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "account")
    private Account account;

    @ManyToOne
    @JoinColumn(name = "address")
    private Address address;

}
