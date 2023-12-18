package com.example.shopee.service;

import com.example.shopee.enity.Product;
import com.example.shopee.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;


@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    public Mono<Page<Product>> findAllProducts(Pageable pageable) {
        return repository.findAllBy(pageable)
                .collectList()
                .zipWith(repository.count())
                .map(p -> new PageImpl<>(p.getT1(), pageable,p.getT2()));
    }
}
