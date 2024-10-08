package com.didatikos.estoque.model.dto;

public class ProductDto {

    private Long id;
    private String name;
    private Double value;
    private Integer stock;
    private String city;

    public ProductDto(Long id, String name, Double value, Integer stock, String city) {
        this.id = id;
        this.name = name;
        this.value = value;
        this.stock = stock;
        this.city = city;
    }

    public ProductDto() {
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

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
