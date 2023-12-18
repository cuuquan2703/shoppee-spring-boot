package com.example.shopee.repository;

import com.example.shopee.enity.Product;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface ProductRepository extends ReactiveCrudRepository<Product, Long>, R2dbcRepository<Product, Long> {
}
