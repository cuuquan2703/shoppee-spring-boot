package com.example.shopee.repository;

import com.example.shopee.enity.Product;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface ProductRepository extends ReactiveCrudRepository<Product, Long>, R2dbcRepository<Product, Long> {

    @Query(value = "select * from product p where p.product_name like concat('%',:query,'%')")
    Flux<Product> searchProductByProductName(String query);
}
