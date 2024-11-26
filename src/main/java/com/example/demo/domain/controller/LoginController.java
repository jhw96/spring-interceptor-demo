package com.example.demo.domain.controller;

import com.example.demo.domain.service.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private LoginServiceImpl loginServiceImpl;

    @PostMapping("/login")
    public ResponseEntity<String> Login(@RequestParam String email, @RequestParam String password) {
        String response = loginServiceImpl.login(email, password);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
