package com.didatikos.estoque.model.mapper;

import com.didatikos.estoque.model.City;
import com.didatikos.estoque.model.Product;
import com.didatikos.estoque.model.dto.ProductDto;

public class ProductMapper {


    public static ProductDto toDto(Product product) {
        if (product == null) {
            return null;
        }

        String cityName = product.getCity() != null ? product.getCity().getName() : null;

        return new ProductDto(
                product.getId(),
                product.getName(),
                product.getValue(),
                product.getStock(),
                cityName
        );
    }

    public static Product toEntity(ProductDto productDto) {
        if (productDto == null) {
            return null;
        }

        Product product = new Product();
        product.setId(productDto.getId());
        product.setName(productDto.getName());
        product.setValue(productDto.getValue());
        product.setStock(productDto.getStock());

        if (productDto.getCity() != null) {
            City city = new City();
            city.setName(productDto.getCity());
            product.setCity(city);
        }

        return product;
    }
}