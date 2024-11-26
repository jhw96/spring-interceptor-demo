package com.example.demo.domain.service;

import com.example.demo.domain.entity.Member;
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
        return memberRepository.get(email);
    }

    public List<Member> getMemberList() {
        return new ArrayList<>(memberRepository.values());
    }



}
