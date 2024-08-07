package com.didatikos.estoque.Model;


import jakarta.persistence.*;
import org.springframework.data.annotation.Id;


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
