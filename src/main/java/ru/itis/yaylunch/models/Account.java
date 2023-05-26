package ru.itis.yaylunch.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Data
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

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "confirm_code")
    private String confirmCode;

    @Enumerated(value = EnumType.STRING)
    private State state;

    @Enumerated(value = EnumType.STRING)
    private Role role;

    @OneToOne(mappedBy = "account")
    @JsonManagedReference
    private Client client;

    @OneToOne(mappedBy = "account")
    @JsonManagedReference
    private School schools;

    @OneToOne(mappedBy = "account")
    @JsonManagedReference
    private Restaurant restaurants;

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return phone;
    }

    public String getConfirmCode() {
        return confirmCode;
    }

    public State getState() {
        return state;
    }

    public Role getRole() {
        return role;
    }

    public Client getClient() {
        return client;
    }

    public School getSchools() {
        return schools;
    }

    public Restaurant getRestaurants() {
        return restaurants;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", confirmCode='" + confirmCode + '\'' +
                ", state=" + state +
                ", role=" + role +
                '}';
    }
}
