package com.example.shopee.service;

import com.example.shopee.dto.ProductDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductService {
    Flux<ProductDto> getAllProduct();

    Mono<ProductDto> getProductById(Long productId);

    Mono<ProductDto> saveProduct(ProductDto productDto);

    Mono<Void> deleteProduct(Long productId);

    Flux<ProductDto> searchProductByName(String query);
}
