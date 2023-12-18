package com.example.shopee.service;

import com.example.shopee.dto.ProductDto;
import com.example.shopee.enity.Product;
import com.example.shopee.repository.ProductRepository;
import com.example.shopee.util.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import reactor.core.publisher.Mono;


@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    @Autowired
    private ProductMapper mapper;

    public Mono<Page<ProductDto>> findAllProducts(Pageable pageable) {
        return repository.findAllBy(pageable)
                .map(u -> mapper.entityToDto(u))
                .collectList()
                .zipWith(repository.count())
                .map(p -> new PageImpl<>(p.getT1(), pageable,p.getT2()));
    }

    public Mono<ProductDto> findById(Long id) {
        return repository.findById(id).map(u -> mapper.entityToDto(u));
    }
}
