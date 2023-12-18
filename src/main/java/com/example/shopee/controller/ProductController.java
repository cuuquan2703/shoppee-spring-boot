package com.example.shopee.controller;

import com.example.shopee.enity.Product;
import com.example.shopee.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@Controller
@RestController
@RequestMapping("/product")
public class ProductController {

    private ProductService service;

    @RequestMapping("/all")
    public Mono<Page<Product>> allProducts(@RequestParam(name="page", defaultValue = "0") int page,
                                           @RequestParam(name="size", defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page,size);
        return service.findAllProducts(pageable);
    }
}
