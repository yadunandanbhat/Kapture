package com.kapture.springstore.service;

import com.kapture.springstore.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> searchProducts(String query);

    List<Product> findAll();

    Optional<Product> findById(Long id);

    Product create(Product product);

    Product update(Product product);

    Product updateAttr(Product product);

    void deleteById(Long id);
}
