package ru.itis.yaylunch.models;

import jdk.jfr.Enabled;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@ToString
@Table(name = "persistent_logins")
public class PersistentLogins {
    @Id
    private Long id;

    private String username;
    private String series;
    private String token;
    private String last_used;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
