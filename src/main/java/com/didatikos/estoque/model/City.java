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
    private String state;
    @OneToMany(mappedBy = "city")
    private List<Product> products;

    public City(Long id, String name, String state, List<Product> products) {
        this.id = id;
        this.name = name;
        this.state = state;
        this.products = products;
    }

    public City() {

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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }


}
