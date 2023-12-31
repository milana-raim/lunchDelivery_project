package ru.itis.yaylunch.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Getter
@Setter
public class Account {
    public enum State {
        NOT_CONFIRMED, CONFIRMED, DELETED, BANNED
    }

    public enum Role {
        USER, SCHOOL, RESTAURANT, ADMIN
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email")
    private String email;

    @Column(name = "hash_password")
    private String password;

    @Column(name = "phone")
    private String phone;

    @Column(name = "confirm_code")
    private String confirmCode;

    @Enumerated(value = EnumType.STRING)
    private State state;

    @Enumerated(value = EnumType.STRING)
    private Role role;

    @OneToOne(mappedBy = "account", cascade = {CascadeType.ALL})
    @JsonManagedReference
    private Client client;

    @OneToOne(mappedBy = "account", cascade = {CascadeType.ALL})
    @JsonManagedReference
    private School school;

    @OneToOne(mappedBy = "account", cascade = {CascadeType.ALL})
    @JsonManagedReference
    private Restaurant restaurant;

    @OneToOne(mappedBy = "account", cascade = {CascadeType.ALL})
    @JsonManagedReference
    private Basket basket;

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", confirmCode='" + confirmCode + '\'' +
                ", state=" + state +
                ", role=" + role +
                '}';
    }
}
