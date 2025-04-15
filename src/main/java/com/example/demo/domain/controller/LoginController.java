package com.example.demo.domain.controller;

import com.example.demo.domain.service.LoginServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private LoginServiceImpl loginServiceImpl;

    //RestController일 때, Login에 대한 처리
    @PostMapping("/login")
    public ResponseEntity<String> Login(HttpServletRequest request, HttpSession session) {
        // AS-IS : @RequestBody 이용하여 Request Body 값 받고 있었음
        // To-BE : LoginInterceptor와 동일하게 HttpServletRequest를 통해서 요청 값을 받음. 요청 파라미터 맞춰주지 않으니 인터셉터에서 컨트롤러로 요청이 오지 않았었음.


        return ResponseEntity.ok().build();
    }

    /*
    Controller일 때, Login에 대한 처리
    => 로그인 인터셉터 처리 후에, 컨트롤러로 넘어왔을 때 성공했으니까 Main 페이지로 넘기고 있었음
       But, ajax로 요청했기 때문에 main은 json응답으로 인식됨. JSON 페이지 반환을 원하면 form 형태로 서버에 제출해야함.
    @PostMapping("/login")
    public String Login(HttpServletRequest request, HttpSession session) {
        return "main";

     */
}
