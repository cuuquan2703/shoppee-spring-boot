package com.example.shopee.enity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private long id;

    @Column(name="product_name",nullable = false)
    private String productName;

    @Column(name="price",nullable = false)
    private float price;

    @Column(name="image",nullable = false)
    private String image;

    @Column(name="summary", nullable = false)
    private String summary;

}
