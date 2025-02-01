package com.example.demo.domain.controller;

import com.example.demo.domain.entity.Member;
import com.example.demo.domain.exception.CustomException;
import com.example.demo.domain.service.MemberServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {

    @Autowired
    private MemberServiceImpl memberServiceImpl;

    @GetMapping("/member")
    public ResponseEntity<Member> findById(@RequestParam String email) {

        HttpHeaders headers = new HttpHeaders();
        ResponseEntity responseEntity;

        try {
            Member member = memberServiceImpl.findByEmail(email);
            responseEntity = new ResponseEntity<>(member, headers, HttpStatus.OK);
        } catch (RuntimeException e) {
            responseEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return responseEntity;
    }

}
