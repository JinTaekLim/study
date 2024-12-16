package com.study.study.domain;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.study.study.global.util.test.IntegrationTest;
import jakarta.servlet.http.HttpSession;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.ui.Model;

class MemberTest extends IntegrationTest {

  @LocalServerPort
  private int port;

  @Autowired
  private TestRestTemplate restTemplate;

  @Autowired
  private MemberService memberService;

  @Test
  void test() {

    String url = "http://localhost:" + port + "/api/member/test";

    ResponseEntity<String> responseEntity = restTemplate.getForEntity(
        url,
        String.class
    );
  }

  @Test
  void login() {

    HttpHeaders headers = new HttpHeaders();
    HttpEntity<String> entity = new HttpEntity<>(headers);

    String url = "http://localhost:" + port + "/api/member/login";

    ResponseEntity<String> responseEntity = restTemplate.exchange(
        url, HttpMethod.POST, entity, String.class);

  }
}