package ru.itis.yaylunch.models.newer;

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
public class Account {
    public enum State {
        NOT_CONFIRMED, CONFIRMED, DELETED, BANNED
    }

    public enum Role {
        USER, ORGANIZATION, ADMIN
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

    @OneToMany(mappedBy = "account")
    @JsonManagedReference
    private List<Client> clients;

    @OneToMany(mappedBy = "account")
    @JsonManagedReference
    private List<School> schools;

    @OneToMany(mappedBy = "account")
    @JsonManagedReference
    private List<Restaurant> restaurants;
}
