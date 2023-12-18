package com.example.shopee.controller;


import com.example.shopee.dto.UserDto;
import com.example.shopee.enity.USER_ROLE;
import com.example.shopee.enity.User;
import com.example.shopee.repository.UserRepository;
import com.example.shopee.util.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepository repository;
    
    @Autowired
    private UserMapper mapper;

    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable Long id){
        User user = repository.findById(id).orElseThrow(() -> new RuntimeException("User not exist"));
        return mapper.entityToDto(user);
    }

    @PutMapping("/new")
    public UserDto newUser() {
        User user = new User();
        user.setUsername("cquan");
        user.setPassword("cquan");
        user.setRole(USER_ROLE.NORMAL);
        repository.save(user);
        return mapper.entityToDto(user);
    }
}
