package com.example.shopee.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.shopee.payload.request.LoginRequest;
import com.example.shopee.payload.request.SignupRequest;
import com.example.shopee.service.AuthService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
  @Autowired
  AuthService authService;


  @PostMapping("/signin")
  public ResponseEntity<?> login(@Valid @RequestBody LoginRequest loginRequest) {
    return authService.authenticateUser(loginRequest);
  }

  @PostMapping("/signup")
  public ResponseEntity<?> signup(@Valid @RequestBody SignupRequest signUpRequest) {
   return authService.registerUser(signUpRequest);
  }

  @PostMapping("/signout")
  public ResponseEntity<?> logout() {
    return authService.logoutUser();
  }
}
