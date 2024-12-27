package com.example.demo.domain.controller;

import com.example.demo.domain.exception.CustomException;
import com.example.demo.domain.service.LoginServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
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
    public ResponseEntity<String> Login(HttpServletRequest request, HttpSession session) {
        // AS-IS : @RequestBody 이용하여 Request Body 값 받고 있었음
        // To-BE : LoginInterceptor와 동일하게 HttpServletRequest를 통해서 요청 값을 받음. 요청 파라미터 맞춰주지 않으니 인터셉터에서 컨트롤러로 요청이 오지 않았었음.


        return ResponseEntity.ok().build();
    }
}
