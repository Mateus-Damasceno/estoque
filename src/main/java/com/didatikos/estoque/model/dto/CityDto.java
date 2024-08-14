package com.didatikos.estoque.model.dto;


import java.util.List;

public class CityDto {

    private Long id;
    private String name;
    private String state;
    private List<ProductDto> products;

    public CityDto(List<ProductDto> products, String state, String name, Long id) {
        this.products = products;
        this.state = state;
        this.name = name;
        this.id = id;
    }

    public CityDto() {

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

    public List<ProductDto> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDto> products) {
        this.products = products;
    }
}
