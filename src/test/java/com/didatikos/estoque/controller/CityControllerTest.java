package com.didatikos.estoque.controller;

import com.didatikos.estoque.model.dto.CityDto;
import com.didatikos.estoque.model.dto.ProductDto;
import com.didatikos.estoque.service.CityService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class CityControllerTest {

    private MockMvc mockMvc;

    @Mock
    private CityService cityService;

    @InjectMocks
    private CityController cityController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(cityController).build();
    }

    @Test
    void testGetAllCities() throws Exception {
        // Arrange
        ProductDto product1 = new ProductDto(1L, "Product1", 10.0, 100, "City1");
        ProductDto product2 = new ProductDto(2L, "Product2", 20.0, 200, "City1");
        List<ProductDto> productsCity1 = Arrays.asList(product1, product2);

        CityDto city1 = new CityDto(productsCity1, "State1", "City1",1L );

        ProductDto product3 = new ProductDto(3L, "Product3", 30.0, 300, "City2");
        List<ProductDto> productsCity2 = List.of(product3);

        CityDto city2 = new CityDto(productsCity2, "State2", "City2", 2L);

        List<CityDto> cityList = Arrays.asList(city1, city2);

        when(cityService.findAll()).thenReturn(cityList);

        // Act & Assert
        mockMvc.perform(get("/cities")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(
                        "[{" +
                                "\"id\":1," +
                                "\"name\":\"City1\"," +
                                "\"state\":\"State1\"," +
                                "\"products\":[" +
                                "{" +
                                "\"id\":1," +
                                "\"name\":\"Product1\"," +
                                "\"value\":10.0," +
                                "\"stock\":100," +
                                "\"city\":\"City1\"" +
                                "}," +
                                "{" +
                                "\"id\":2," +
                                "\"name\":\"Product2\"," +
                                "\"value\":20.0," +
                                "\"stock\":200," +
                                "\"city\":\"City1\"" +
                                "}" +
                                "]" +
                                "},{" +
                                "\"id\":2," +
                                "\"name\":\"City2\"," +
                                "\"state\":\"State2\"," +
                                "\"products\":[" +
                                "{" +
                                "\"id\":3," +
                                "\"name\":\"Product3\"," +
                                "\"value\":30.0," +
                                "\"stock\":300," +
                                "\"city\":\"City2\"" +
                                "}" +
                                "]" +
                                "}]"
                ));
    }
}
