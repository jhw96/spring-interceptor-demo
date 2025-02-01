package com.example.demo.domain.controller;

import com.example.demo.domain.entity.Member;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class MemberControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void 멤버조회_테스트() throws Exception {
        // Given
        String email = "test@test.com";
        Member expectedMember = new Member(email, "password");


        // When
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/member")
                        .param("email", email)) // 쿼리 파라미터 추가
                .andExpect(status().isOk()) // 응답 상태 코드 검증
                .andReturn();

        String jsonResponse = result.getResponse().getContentAsString();
        Member actualMember = objectMapper.readValue(jsonResponse, Member.class);

        // Then
        assertThat(actualMember).isEqualTo(expectedMember);
    }

    @Test
    void 멤버조회_실패테스트() throws Exception {
        //Given
        String email = "test3@test.com";

        // When
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/member")
                        .param("email", email)) // 쿼리 파라미터 추가
                        .andExpect(status().isBadRequest())
                        .andReturn();
    }

}
