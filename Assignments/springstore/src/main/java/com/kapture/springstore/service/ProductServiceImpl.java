package com.kapture.springstore.service;

import com.kapture.springstore.entity.Product;
import com.kapture.springstore.repository.ProductRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService{
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> searchProducts(String query) {
        List<Product> products = productRepository.searchProducts(query);
        return products;
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public Product create(Product product) {
        if (product.getDateCreated() == null) {
            product.setDateCreated(LocalDateTime.now());
            product.setDateUpdated(null);
        }

        return productRepository.save(product);
    }

    @Override
    public Product update(Product product) {
        product.setDateUpdated(LocalDateTime.now());
        return productRepository.save(product);
    }

    @Override
    public void deleteById(Long id) {
        this.productRepository.deleteById(id);
    }
}
