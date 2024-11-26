package com.example.demo.domain.controller;

import com.example.demo.domain.entity.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class LoginControllerTest {

    final static Member member1 = new Member("test@test.com", "password");
    final static Member member2 = new Member("test2@test.com", "password2");

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void 로그인테스트() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("email", member1.getEmail());
        map.add("password", member1.getPassword());

        HttpEntity<MultiValueMap<String,String>> request = new HttpEntity<>(map, headers);

        String url = "http://localhost:" + port + "/login";
        ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);


        assertThat(response.getBody()).isEqualTo(member1.getEmail());

    }


}
