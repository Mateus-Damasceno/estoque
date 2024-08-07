package com.didatikos.estoque.service;


import com.didatikos.estoque.model.City;
import com.didatikos.estoque.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {
    @Autowired
    private CityRepository cityRepository;

    public List<City> findAll() {
        return cityRepository.findAll();
    }
}