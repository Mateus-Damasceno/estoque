package com.didatikos.estoque.model.mapper;

import com.didatikos.estoque.model.City;
import com.didatikos.estoque.model.dto.CityDto;
import com.didatikos.estoque.model.dto.ProductDto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CityMapper {

    // Converte de City para CityDto
    public static CityDto toDto(City city) {
        if (city == null) {
            return null;
        }

        List<ProductDto> productDtos = city.getProducts() != null
                ? city.getProducts().stream()
                .map(ProductMapper::toDto)
                .collect(Collectors.toList())
                : new ArrayList<>();

        return new CityDto(
                productDtos,
                city.getState(),
                city.getName()
        );
    }

    // Converte de CityDto para City
    public static City toEntity(CityDto cityDto) {
        if (cityDto == null) {
            return null;
        }

        City city = new City();
        city.setName(cityDto.getName());
        city.setState(cityDto.getState());


        return city;
    }
}