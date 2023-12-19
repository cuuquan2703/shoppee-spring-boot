package com.example.shopee.dto;
import javax.persistence.Column;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDto {

    private long id;
    private String productName;
    private float price;
    private String image;
    private String summary;
}
