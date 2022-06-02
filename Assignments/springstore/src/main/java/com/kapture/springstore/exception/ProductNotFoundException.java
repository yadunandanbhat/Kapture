package com.kapture.springstore.exception;

public class ProductNotFoundException extends ApiException{
    private final Long productId;
    public ProductNotFoundException(Long productId) {
        this.productId = productId;
    }

    public Long getProductId() {
        return productId;
    }
}
