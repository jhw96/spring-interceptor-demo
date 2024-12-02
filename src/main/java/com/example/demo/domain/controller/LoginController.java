package com.example.demo.domain.controller;

import com.example.demo.domain.service.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {

    @Autowired
    private LoginServiceImpl loginServiceImpl;

    @PostMapping("/login")
    public ResponseEntity<String> Login(@RequestBody Map<String, String> map) {
        String email = map.get("email");
        String password = map.get("password");
        HttpHeaders headers = new HttpHeaders();

        ResponseEntity responseEntity;
        try{
            String response = loginServiceImpl.login(email,password);
            responseEntity = new ResponseEntity<>(response, headers,HttpStatus.OK);

        } catch(RuntimeException exception) {
            responseEntity = new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }

        return responseEntity;
    }
}
