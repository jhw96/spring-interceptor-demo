package com.example.demo.domain.service;


import com.example.demo.domain.entity.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl {

    @Autowired
    private MemberServiceImpl memberService;


    public String login(String email, String password) {
        Member member = memberService.findByEmail(email);

        if(member.getPassword().equals(password))
            return member.getEmail();

        return "Login Fail";
    }

}
