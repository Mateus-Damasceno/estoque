package com.didatikos.estoque.model.dto;

public class ProductDto {

    private String name;
    private Double value;
    private Integer stock;
    private String city;

    public ProductDto(String name, Double value, Integer stock, String cityDto) {
        this.name = name;
        this.value = value;
        this.stock = stock;
        this.city = cityDto;
    }

    public ProductDto() {

    }

    public String getCityDto() {
        return city;
    }

    public void setCityDto(String cityDto) {
        this.city = cityDto;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
