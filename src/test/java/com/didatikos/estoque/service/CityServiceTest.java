package com.didatikos.estoque.service;

import com.didatikos.estoque.model.City;
import com.didatikos.estoque.model.dto.CityDto;
import com.didatikos.estoque.repository.CityRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

class CityServiceTest {

    @InjectMocks
    private CityService cityService;

    @Mock
    private CityRepository cityRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindAll() {
        City city = new City(1L, "City 1", "State 1", null);
        when(cityRepository.findAll()).thenReturn(List.of(city));

        List<CityDto> cities = cityService.findAll();

        assertNotNull(cities);
        assertEquals(1, cities.size());
        assertEquals("City 1", cities.get(0).getName());
    }

    @Test
    void testFindByName() {
        City city = new City(1L, "City 1", "State 1", null);
        when(cityRepository.findByName("City 1")).thenReturn(city);

        City foundCity = cityService.findByName("City 1");

        assertNotNull(foundCity);
        assertEquals("City 1", foundCity.getName());
    }

    @Test
    void testSave() {
        City city = new City(null, "City 1", "State 1", null);
        City savedCity = new City(1L, "City 1", "State 1", null);
        when(cityRepository.save(city)).thenReturn(savedCity);

        City result = cityService.save(city);

        assertNotNull(result);
        assertEquals("City 1", result.getName());
        assertEquals(1L, result.getId());
    }
}
