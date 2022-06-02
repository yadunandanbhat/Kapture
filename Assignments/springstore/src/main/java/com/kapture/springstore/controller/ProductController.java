package com.kapture.springstore.controller;

import com.kapture.springstore.entity.Product;
import com.kapture.springstore.exception.BeanValidationException;
import com.kapture.springstore.exception.ProductNotFoundException;
import com.kapture.springstore.service.ProductService;
import com.kapture.springstore.util.UriUtil;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final MessageSource messageSource;
    private final ProductService productService;

    public ProductController(MessageSource messageSource, ProductService productService) {
        this.messageSource = messageSource;
        this.productService = productService;
    }

    @GetMapping("/search")
    public ResponseEntity<List<Product>> searchProducts(@RequestParam("query") String query){
        return ResponseEntity.ok(productService.searchProducts(query));
    }

    @GetMapping
    public List<Product> findAll() {
        return this.productService.findAll();
    }

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody @Valid Product product, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new BeanValidationException(bindingResult);
        }

        var createdProduct = this.productService.create(product);
        var uri = UriUtil.path("/{id}", createdProduct.getId());

        return ResponseEntity.created(uri).body(createdProduct);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id) {
        return this.productService.findById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ProductNotFoundException(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable Long id, @RequestBody @Valid Product product, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new BeanValidationException(bindingResult);
        }

        return this.productService.findById(id)
                .map(existingProductDto -> {
                    product.setId(id);
                    product.setDateCreated(existingProductDto.getDateCreated());
                    return ResponseEntity.ok(this.productService.update(product));
                }).orElseThrow(() -> new ProductNotFoundException(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return this.productService.findById(id)
                .map(productDto -> {
                    this.productService.deleteById(id);
                    return ResponseEntity.noContent().build();
                })
                .orElseThrow(() -> new ProductNotFoundException(id));
    }
}
