package com.example.shopee.controller;

import com.example.shopee.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("api/product")
public class ProductController {

    private ProductService productService;

    @GetMapping("/hello")
    public String hello(){
        return "Hello you, welcome to my chanel";
    }
}
