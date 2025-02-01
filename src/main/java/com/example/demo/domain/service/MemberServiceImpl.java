package com.example.demo.domain.service;

import com.example.demo.domain.entity.Member;
import com.example.demo.domain.exception.CustomException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MemberServiceImpl {

    private static Map<String, Member> memberRepository = new HashMap<>();


    public MemberServiceImpl() {
        Member member1 = new Member("test@test.com", "password");
        Member member2 = new Member("test2@test.com", "password2");

        memberRepository.put(member1.getEmail(), member1);
        memberRepository.put(member2.getEmail(), member2);
    }

    public Member findByEmail(String email) {
        Member member = memberRepository.get(email);

        if(member.equals(null)) {
            throw new RuntimeException("No Data Exception");
        }

        return member;
    }

    public List<Member> getMemberList() {
        return new ArrayList<>(memberRepository.values());
    }

}
