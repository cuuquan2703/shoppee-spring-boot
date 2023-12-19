package com.example.shopee.util;

import com.example.shopee.dto.ProductDto;
import com.example.shopee.enity.product.Product;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

//@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProductMapper {

    //convert dto to entity
    public static ProductDto entityToDto(Product product) {
        ProductDto productDto = new ProductDto(
                product.getId(),
                product.getProductName(),
                product.getPrice(),
                product.getImage(),
                product.getSummary()
        );
        return productDto;
    }
    //convert entity to dto
    public static Product dtoToEntity(ProductDto productDto) {
        Product product = new Product(
                productDto.getId(),
                productDto.getProductName(),
                productDto.getPrice(),
                productDto.getImage(),
                productDto.getSummary()
        );
        return product;
    }
}
