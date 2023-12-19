package com.example.shopee.controller;

import com.example.shopee.dto.ProductDto;
import com.example.shopee.enity.Product;
import com.example.shopee.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import com.example.shopee.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
@RestController
@AllArgsConstructor
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService service;

    @RequestMapping("/all")
    public Mono<Page<ProductDto>> allProducts(@RequestParam(name="page", defaultValue = "0") int page,
                                              @RequestParam(name="size", defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page,size);
        return service.findAllProducts(pageable);
    }

    @RequestMapping("/{id}")
    public Mono<ProductDto> productById(@PathVariable Long id) {
        return service.findById(id);
    }

    @MessageMapping("/get_product")
    @SendTo("/topic/products")
    public String allProductWebSocet(String message) throws  Exception {
        return "Hi there";
    }
    
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
