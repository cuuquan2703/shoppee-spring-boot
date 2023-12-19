package com.example.shopee.controller;


import com.example.shopee.dto.UserDto;
import com.example.shopee.enity.USER_ROLE;
import com.example.shopee.enity.User;
import com.example.shopee.repository.UserRepository;
import com.example.shopee.util.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("user")
@Controller
public class UserController {
    @Autowired
    private UserRepository repository;
    
    @Autowired
    private UserMapper mapper;


    @PutMapping("/new")
    public UserDto newUser() {
        User user = new User();
        user.setUsername("cquan");
        user.setPassword("cquan");
        user.setRole(USER_ROLE.NORMAL);
        System.out.println(user);
        System.out.println(mapper.entityToDto(user));
        repository.save(user);

        return mapper.entityToDto(user);
    }
}
