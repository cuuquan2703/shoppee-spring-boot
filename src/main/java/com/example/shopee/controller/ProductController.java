package com.example.shopee.controller;

import com.example.shopee.dto.ProductDto;
import com.example.shopee.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@AllArgsConstructor
@RequestMapping("api/product")
public class ProductController {

    private ProductService productService;

    @GetMapping("/hello")
    public String hello(){
        return "Hello you, welcome to my chanel";
    }

    @GetMapping
    public Flux<ProductDto> getAllProduct() {
        return productService.getAllProduct();
    }

    @RequestMapping("/{id}")
    public Mono<ProductDto> getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<ProductDto> saveProduct(@RequestBody ProductDto productDto) {
        return productService.saveProduct(productDto);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public Mono<ProductDto> updateProduct(@RequestBody ProductDto productDto) {
        return productService.saveProduct(productDto);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteProduct(@PathVariable Long id) {
        return productService.deleteProduct(id);
    }

    @GetMapping("/search")
    public Flux<ProductDto> searchProductByName(@RequestParam("query") String query) {
        return productService.searchProductByName(query);
    }
}
