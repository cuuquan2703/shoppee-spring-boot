package com.example.shopee.util;

import com.example.shopee.dto.UserDto;
import com.example.shopee.enity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {
    UserDto entityToDto(User entity);
    User dtoToEntity(UserDto dto);
}
