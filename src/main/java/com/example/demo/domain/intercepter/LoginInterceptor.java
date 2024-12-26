package com.example.demo.domain.intercepter;

import com.example.demo.domain.entity.Member;
import com.example.demo.domain.exception.CustomException;
import com.example.demo.domain.service.MemberServiceImpl;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.HandlerInterceptor;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.stream.Collectors;

public class LoginInterceptor implements HandlerInterceptor {

    public static final String SPRING_SECURITY_CONTEXT_KEY = "SPRING_SECURITY_CONTEXT";

    @Autowired
    private final MemberServiceImpl memberService;


    public LoginInterceptor(MemberServiceImpl memberService) {
        this.memberService = memberService;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String json = new BufferedReader(new InputStreamReader(request.getInputStream()))
                .lines().collect(Collectors.joining(System.lineSeparator()));

        String[] split = json.split(",");

        String email = split[0].split(":")[1].replace("\"", "");
        String password = split[1].split(":")[1].split("}")[0].replace("\"","");

        Member member = memberService.findByEmail(email);

        if (!member.getPassword().equals(password)) {
            throw new CustomException(HttpStatus.BAD_REQUEST, "400", "Login Fail");
        }

        request.getSession().setAttribute(SPRING_SECURITY_CONTEXT_KEY, member);

        return true;
    }

}
