package com.didatikos.estoque.service;


import com.didatikos.estoque.model.City;
import com.didatikos.estoque.model.Product;
import com.didatikos.estoque.model.dto.ProductDto;
import com.didatikos.estoque.model.mapper.ProductMapper;
import com.didatikos.estoque.repository.CityRepository;
import com.didatikos.estoque.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CityRepository cityRepository;

    public List<ProductDto> findAll() {
        return productRepository.findAll().stream()
                .map(ProductMapper::toDto)
                .collect(Collectors.toList());
    }

    public Optional<ProductDto> findById(Long id) {
        return productRepository.findById(id)
                .map(ProductMapper::toDto);
    }

    public ProductDto save(ProductDto productDto) {
        Product product = ProductMapper.toEntity(productDto);

        // Verifica se a cidade já existe no banco de dados
        City city = product.getCity();
        if (city != null && city.getId() == null) {
            // Salva a cidade se ela não estiver salva
            city = cityRepository.save(city);
            product.setCity(city);
        }

        // Verifica se o produto já existe no banco de dados
        if (product.getId() != null) {
            Optional<Product> existingProductOpt = productRepository.findById(product.getId());
            if (existingProductOpt.isPresent()) {
                Product existingProduct = existingProductOpt.get();
                existingProduct.setName(product.getName());
                existingProduct.setValue(product.getValue());
                existingProduct.setStock(product.getStock());
                existingProduct.setCity(product.getCity());
                product = existingProduct;
            }
        }

        return ProductMapper.toDto(productRepository.save(product));
    }

    public ProductDto updateProduct(Long id, ProductDto productDto) throws Exception {
        Optional<Product> existingProductOpt = productRepository.findById(id);
        if (existingProductOpt.isPresent()) {
            Product existingProduct = existingProductOpt.get();
            existingProduct.setName(productDto.getName());
            existingProduct.setValue(productDto.getValue());
            existingProduct.setStock(productDto.getStock());

            // Verifica se a cidade já existe no banco de dados
            City city = existingProductOpt.get().getCity();
            if (city != null && city.getId() == null) {
                // Salva a cidade se ela não estiver salva
                city = cityRepository.save(city);
                existingProduct.setCity(city);
            }
            existingProduct.setId(id);

            return ProductMapper.toDto(productRepository.save(existingProduct));
        } else {
            throw new Exception("Product not found");
        }
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }


}