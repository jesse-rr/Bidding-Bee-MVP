package com.example.product.service;

import com.example.product.dto.ProductRequestDTO;
import com.example.product.model.Product;
import com.example.product.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public void addProduct(ProductRequestDTO request) {
        log.info("ADDING PRODUCT WITH DTO :: {}",request);
        productRepository.save(
                productMapper.toProduct(request)
        );

        // TODO send PRODUCT ADDED notification
    }

    public Product getProductById(Long productId) {
        log.info("GETTING PRODUCT WITH ID :: {}",productId);
        return productRepository.findById(productId)
                .orElseThrow(() -> new EntityNotFoundException("PRODUCT NOT FOUND WITH ID :: "+productId));
    }

    public void alterProductById(Long productId, ProductRequestDTO request) {
        log.info("ALTERING PRODUCT BY ID :: {}", productId);
        Product product = getProductById(productId);
        product.setCategories(request.categories());
        product.setCurrency(request.currency());
        product.setDescription(request.description());
        product.setName(request.name());
        product.setCurrency(request.currency());
        product.setQuantity(request.quantity());
        product.setMinimalBid(request.minimalBid());
        product.setInitialPrice(request.initialPrice());

        productRepository.save(product);
    }

    public void removeProduct(Long productId) {
        log.info("REMOVING PRODUCT - ID :: {}",productId);
        productRepository.updateProductToRemove(productId);
    }

    public List<Product> getProductsInAuction
}
