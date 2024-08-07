package com.didatikos.estoque.model;


import jakarta.persistence.*;
import java.util.List;

@Entity
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="city_id")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "city")
    private List<Product> products;

    public City(Long id, String name, List<Product> products) {
        this.id = id;
        this.name = name;
        this.products = products;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
