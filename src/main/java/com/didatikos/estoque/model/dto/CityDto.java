package com.didatikos.estoque.model.dto;


import java.util.List;

public class CityDto {

    private String name;
    private String state;
    private List<ProductDto> products;

    public CityDto(List<ProductDto> products, String state, String name) {
        this.products = products;
        this.state = state;
        this.name = name;
    }

    public CityDto() {

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
