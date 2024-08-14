package com.didatikos.estoque.controller;

import com.didatikos.estoque.model.dto.ProductDto;
import com.didatikos.estoque.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

class ProductControllerTest {

    @InjectMocks
    private ProductController productController;

    @Mock
    private ProductService productService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllProducts() {
        ProductDto productDto = new ProductDto(1L, "Product 1", 10.0, 5, "City 1");
        when(productService.findAll()).thenReturn(List.of(productDto));

        List<ProductDto> products = productController.getAllProducts();

        assertNotNull(products);
        assertEquals(1, products.size());
        assertEquals("Product 1", products.get(0).getName());
    }

    @Test
    void testGetProductById() {
        ProductDto productDto = new ProductDto(1L, "Product 1", 10.0, 5, "City 1");
        when(productService.findById(1L)).thenReturn(Optional.of(productDto));

        ResponseEntity<ProductDto> response = productController.getProductById(1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("Product 1", response.getBody().getName());
    }

    @Test
    void testGetProductById_NotFound() {
        when(productService.findById(1L)).thenReturn(Optional.empty());

        ResponseEntity<ProductDto> response = productController.getProductById(1L);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    void testCreateProduct() {
        ProductDto productDto = new ProductDto(null, "Product 1", 10.0, 5, "City 1");
        ProductDto savedProduct = new ProductDto(1L, "Product 1", 10.0, 5, "City 1");
        when(productService.save(productDto)).thenReturn(savedProduct);

        ResponseEntity<ProductDto> response = productController.createProduct(productDto);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("Product 1", response.getBody().getName());
    }

    @Test
    void testUpdateProduct() throws Exception {
        ProductDto productDto = new ProductDto(1L, "Updated Product", 15.0, 10, "City 1");
        when(productService.updateProduct(1L, productDto)).thenReturn(productDto);

        ResponseEntity<ProductDto> response = productController.updateProduct(1L, productDto);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("Updated Product", response.getBody().getName());
    }

    @Test
    void testUpdateProduct_NotFound() throws Exception {
        ProductDto productDto = new ProductDto(1L, "Updated Product", 15.0, 10, "City 1");
        when(productService.updateProduct(1L, productDto)).thenThrow(new Exception("Product not found"));

        ResponseEntity<ProductDto> response = productController.updateProduct(1L, productDto);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    void testDeleteProduct() {
        when(productService.findById(1L)).thenReturn(Optional.of(new ProductDto()));

        ResponseEntity<Void> response = productController.deleteProduct(1L);

        verify(productService, times(1)).deleteById(1L);
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }

    @Test
    void testDeleteProduct_NotFound() {
        when(productService.findById(1L)).thenReturn(Optional.empty());

        ResponseEntity<Void> response = productController.deleteProduct(1L);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }
}
