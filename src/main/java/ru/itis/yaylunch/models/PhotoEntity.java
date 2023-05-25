package ru.itis.yaylunch.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PhotoEntity {

    @Id
    private String id;

    private String name;

    private String type;

    private String size;

    private byte[] photo;

}

