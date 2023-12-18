package com.example.shopee.service;

import com.example.shopee.dto.ProductDto;
import reactor.core.publisher.Flux;

public interface ProductService {
    Flux<ProductDto> getAllProduct();
}
