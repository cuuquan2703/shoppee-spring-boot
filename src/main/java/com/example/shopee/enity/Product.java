package com.example.shopee.enity;

import lombok.*;

import javax.persistence.*;

@Data
@Getter@Setter
@AllArgsConstructor@NoArgsConstructor
@Table
public class Product {

//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name="id")
    @Id
    private long id;

//    @Column(name="product_name",nullable = false)
    private String productName;

//    @Column(name="price",nullable = false)
    private float price;

//    @Column(name="image",nullable = false)
    private String image;

//    @Column(name="summary", nullable = false)
    private String summary;

}
