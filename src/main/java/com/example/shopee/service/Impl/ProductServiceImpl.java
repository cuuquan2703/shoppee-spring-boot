package com.example.shopee.service.Impl;

import com.example.shopee.dto.ProductDto;
import com.example.shopee.enity.Product;
import com.example.shopee.repository.ProductRepository;
import com.example.shopee.service.ProductService;
import com.example.shopee.util.ProductMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

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

    @Override
    public Mono<ProductDto> getProductById(Long productId) {
        Mono<Product> productMono = productRepository.findById(productId);

        return productMono
                .map((product -> ProductMapper.entityToDto(product)));
    }

    @Override
    public Mono<ProductDto> saveProduct(ProductDto productDto) {
        //convert Dto to entity
        Product productMono = ProductMapper.dtoToEntity(productDto);
        //save
        Mono<Product> saveProduct = productRepository.save(productMono);
        //convert entity to dto
        return saveProduct.map((product) -> ProductMapper.entityToDto(product));
    }

    @Override
    public Mono<Void> deleteProduct(Long productId) {
        return productRepository.deleteById(productId);
    }

    @Override
    public Flux<ProductDto> searchProductByName(String query) {
        Flux<Product> productFlux = productRepository.searchProductByProductName(query);

        return productFlux
                .map((product)->ProductMapper.entityToDto(product))
                .switchIfEmpty(Flux.empty());
    }
}
