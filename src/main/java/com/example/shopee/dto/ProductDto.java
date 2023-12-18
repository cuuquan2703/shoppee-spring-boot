package com.example.shopee.dto;

import lombok.*;

import javax.persistence.Column;

@Getter@Setter
@AllArgsConstructor@NoArgsConstructor
@Builder
public class ProductDto {

    private long id;
    private String productName;
    private float price;
    private String image;
    private String summary;
}
