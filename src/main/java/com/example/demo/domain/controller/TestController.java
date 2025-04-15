package com.example.demo.domain.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
    @GetMapping("/test")
    public String test() {
        return "login";
    }

    @GetMapping("/main")
    public String main() {
        return "main";
    }

}
