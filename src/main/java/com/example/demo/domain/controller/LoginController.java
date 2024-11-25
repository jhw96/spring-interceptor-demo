package com.example.demo.domain.controller;

import com.example.demo.domain.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpResponse;

@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @GetMapping("/login")
    public ResponseEntity<String> Login() {

        String response = loginService.login();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
