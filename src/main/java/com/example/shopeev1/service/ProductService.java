package com.example.shopeev1.service;

import com.example.shopeev1.data.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAll();

    Product saveProduct(Product product);

    Product findById(Long id);

    void deleteProduct(Long id);
}
