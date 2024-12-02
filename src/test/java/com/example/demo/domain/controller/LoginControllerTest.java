package com.example.demo.domain.controller;

import com.example.demo.domain.entity.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertThrows;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class LoginControllerTest {

    final static Member member1 = new Member("test@test.com", "password");
    final static Member member2 = new Member("test2@test.com", "password2");

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void 로그인_성공테스트() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);


        String requestBody = "{\"email\":\"test@test.com\",\"password\":\"password\"}";

        HttpEntity<String> request = new HttpEntity<>(requestBody, headers);

        String url = "http://localhost:" + port + "/login";
        ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);


        assertThat(response.getBody()).isEqualTo(member1.getEmail());

    }

    @Test
    void 로그인_실패테스트() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        String requestBody = "{\"email\":\"test@test.com\",\"password\":\"test\"}";

        HttpEntity<String> request = new HttpEntity<>(requestBody, headers);

        String url = "http://localhost:" + port + "/login";
        ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.FORBIDDEN);
    }


}
