package org.example.gallery.backend.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@Entity(name="items")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(name="imgPath", length=200)
    private String imgPath;

    @Column
    private int price;

    @Column(name="discountPer")
    private Integer discountPer;
}
