package com.example.shopee.util;

import com.example.shopee.dto.ProductDto;
import com.example.shopee.enity.product.Product;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProductMapper {
    ProductDto entityToDto(Product entity);
    Product dtoToEntity(ProductDto dto);
}
