package org.example.gallery.backend.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity(name="members" )
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column(length=50, nullable = false, unique = true)
    private String email;

    @Column(length = 50, nullable = false)
    private String password;

}
