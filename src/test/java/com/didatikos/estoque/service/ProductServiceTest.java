package com.didatikos.estoque.service;


import com.didatikos.estoque.model.City;
import com.didatikos.estoque.model.Product;
import com.didatikos.estoque.model.dto.ProductDto;
import com.didatikos.estoque.model.mapper.ProductMapper;
import com.didatikos.estoque.repository.CityRepository;
import com.didatikos.estoque.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
public class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @Mock
    private CityRepository cityRepository;

    @InjectMocks
    private ProductService productService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindAll() {
        Product product = new Product(1L, "Product1", 100.0, 10, new City(1L, "City1", "State1", null));
        when(productRepository.findAll()).thenReturn(List.of(product));

        List<ProductDto> products = productService.findAll();

        assertEquals(1, products.size());
        assertEquals("Product1", products.get(0).getName());
    }

    @Test
    public void testFindById() {
        Product product = new Product(1L, "Product1", 100.0, 10, new City(1L, "City1", "State1", null));
        when(productRepository.findById(1L)).thenReturn(Optional.of(product));

        Optional<ProductDto> productDto = productService.findById(1L);

        assertTrue(productDto.isPresent());
        assertEquals("Product1", productDto.get().getName());
    }

    @Test
    public void testSave() {
        ProductDto productDto = new ProductDto("Product1", 100.0, 10, "City1");
        Product product = ProductMapper.toEntity(productDto);
        product.setId(1L);
        when(cityRepository.save(any(City.class))).thenReturn(new City(1L, "City1", "State1", null));
        when(productRepository.save(any(Product.class))).thenReturn(product);

        ProductDto savedProduct = productService.save(productDto);

        assertNotNull(savedProduct);
        assertEquals("Product1", savedProduct.getName());
    }

    @Test
    public void testUpdateProduct() throws Exception {
        ProductDto productDto = new ProductDto("UpdatedProduct", 200.0, 20, "City1");
        Product product = new Product(1L, "Product1", 100.0, 10, new City(1L, "City1", "State1", null));
        when(productRepository.findById(1L)).thenReturn(Optional.of(product));
        when(productRepository.save(any(Product.class))).thenReturn(product);

        ProductDto updatedProduct = productService.updateProduct(1L, productDto);

        assertNotNull(updatedProduct);
        assertEquals("UpdatedProduct", updatedProduct.getName());
    }

    @Test
    public void testDeleteById() {
        doNothing().when(productRepository).deleteById(1L);

        productService.deleteById(1L);

        verify(productRepository, times(1)).deleteById(1L);
    }
}