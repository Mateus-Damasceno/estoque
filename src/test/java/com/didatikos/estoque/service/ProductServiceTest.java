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
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class ProductServiceTest {

    @InjectMocks
    private ProductService productService;

    @Mock
    private ProductRepository productRepository;

    @Mock
    private CityRepository cityRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindAll() {
        Product product = new Product(1L, "Product 1", 10.0, 5, new City());
        when(productRepository.findAll()).thenReturn(List.of(product));

        List<ProductDto> result = productService.findAll();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Product 1", result.get(0).getName());
    }

    @Test
    void testFindById() {
        Product product = new Product(1L, "Product 1", 10.0, 5, new City());
        when(productRepository.findById(1L)).thenReturn(Optional.of(product));

        Optional<ProductDto> result = productService.findById(1L);

        assertTrue(result.isPresent());
        assertEquals("Product 1", result.get().getName());
    }

    @Test
    void testSaveProduct() {
        ProductDto productDto = new ProductDto(null, "Product 1", 10.0, 5, "City 1");
        Product product = ProductMapper.toEntity(productDto);
        when(productRepository.save(any(Product.class))).thenReturn(product);

        ProductDto savedProduct = productService.save(productDto);

        assertNotNull(savedProduct);
        assertEquals("Product 1", savedProduct.getName());
    }

    @Test
    void testUpdateProduct() throws Exception {
        Product product = new Product(1L, "Product 1", 10.0, 5, new City(1L, "City 1", "State 1", null));
        ProductDto productDto = new ProductDto(1L, "Updated Product", 15.0, 10, "City 1");
        when(productRepository.findById(1L)).thenReturn(Optional.of(product));
        when(productRepository.save(any(Product.class))).thenReturn(product);

        ProductDto updatedProduct = productService.updateProduct(1L, productDto);

        assertNotNull(updatedProduct);
        assertEquals("Updated Product", updatedProduct.getName());
        assertEquals(15.0, updatedProduct.getValue());
    }

    @Test
    void testUpdateProductThrowsException() {
        when(productRepository.findById(1L)).thenReturn(Optional.empty());

        Exception exception = assertThrows(Exception.class, () -> {
            productService.updateProduct(1L, new ProductDto());
        });

        assertEquals("Product not found", exception.getMessage());
    }

    @Test
    void testDeleteById() {
        doNothing().when(productRepository).deleteById(1L);

        productService.deleteById(1L);

        verify(productRepository, times(1)).deleteById(1L);
    }
}