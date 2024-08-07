package com.didatikos.estoque.model;


import jakarta.persistence.*;


@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Double value;
    private Integer stock;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;
}
