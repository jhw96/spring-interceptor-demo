package com.example.demo.domain.controller;

import com.example.demo.domain.entity.Member;
import com.example.demo.domain.service.MemberServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
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

        System.out.println(memberServiceImpl.findByEmail(email));

        return ResponseEntity.status(HttpStatus.OK).body(memberServiceImpl.findByEmail(email));
    }

}
