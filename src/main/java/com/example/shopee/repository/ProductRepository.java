package com.example.shopee.repository;

import com.example.shopee.enity.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Repository
public interface ProductRepository extends ReactiveCrudRepository<Product, Long>, R2dbcRepository<Product, Long> {

    @Query(value = "select * from product p where p.product_name like concat('%',:query,'%')")
    Flux<Product> searchProductByProductName(String query);

    Flux<Product> findAllBy(Pageable pageable);
    Mono<Product> findById(Long id);
}
