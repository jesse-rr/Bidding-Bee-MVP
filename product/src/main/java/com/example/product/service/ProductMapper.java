package com.example.product.service;

import com.example.product.dto.ProductRequestDTO;
import com.example.product.model.Product;
import org.springframework.stereotype.Service;

@Service
public class ProductMapper {
    public Product toProduct(ProductRequestDTO request) {
        return Product.builder()
                .name(request.name())
                .currency(request.currency())
                .description(request.description())
                .price(request.price())
                .quantity(request.quantity())
                .userId(request.userId())
                .categories(request.categories()).build();
    }
}
