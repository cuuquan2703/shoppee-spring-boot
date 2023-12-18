package com.example.shopee.service.Impl;

import com.example.shopee.dto.ProductDto;
import com.example.shopee.enity.Product;
import com.example.shopee.repository.ProductRepository;
import com.example.shopee.service.ProductService;
import com.example.shopee.util.ProductMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    @Override
    public Flux<ProductDto> getAllProduct() {
        Flux<Product> productFlux = productRepository.findAll();
        return productFlux
                .map((product)-> ProductMapper.entityToDto(product))
                .switchIfEmpty(Flux.empty());
    }
}
