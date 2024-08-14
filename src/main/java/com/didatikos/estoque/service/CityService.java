package com.didatikos.estoque.service;

import com.didatikos.estoque.model.City;
import com.didatikos.estoque.model.dto.CityDto;
import com.didatikos.estoque.model.mapper.CityMapper;
import com.didatikos.estoque.repository.CityRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CityService {
    @Autowired
    private CityRepository cityRepository;

    public List<CityDto> findAll() {
        return cityRepository.findAll().stream()
                .map(CityMapper::toDto)
                .collect(Collectors.toList());
    }

    public City findByName(String name) {
        return cityRepository.findByName(name);
    }

    public City save(City city) {
        return cityRepository.save(city);
    }
}