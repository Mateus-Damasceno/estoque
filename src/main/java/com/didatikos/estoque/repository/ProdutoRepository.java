package com.didatikos.estoque.repository;


import com.didatikos.estoque.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Product, Long> {
}
