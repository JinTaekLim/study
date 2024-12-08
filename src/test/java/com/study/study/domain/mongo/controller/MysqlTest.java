package com.study.study.domain.mongo.controller;

import com.study.study.domain.mysql.dto.MysqlSaveDto;
import com.study.study.domain.mysql.dto.ReservationItem;
import com.study.study.global.util.test.IntegrationTest;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.IntStream;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

class MysqlTest extends IntegrationTest {


  @LocalServerPort
  private int port;

  @Autowired
  private TestRestTemplate restTemplate;

  private List<ReservationItem> getReservationList(int size) {
    return IntStream.range(0, size)
        .mapToObj(i -> ReservationItem.builder()
            .date(LocalDate.now())
            .content("content")
            .build())
        .toList();
  }

  @Test
  void save() {

    List<ReservationItem> reservationList = getReservationList(20);

    MysqlSaveDto.Request request = MysqlSaveDto.Request.builder()
        .name("name")
        .phone("phone")
        .startDate(LocalDate.now())
        .endDate(LocalDate.now())
        .reservationItems(reservationList)
        .build();

    String url = "http://localhost:" + port + "/api/mysql/save";

    ResponseEntity<String> responseEntity = restTemplate.postForEntity(
        url,
        request,
        String.class
    );
  }

  @RepeatedTest(10000)
  void getCustomerInfo() {

    // 1 ~ 500001
    Long customerId = 1L;

    String url = "http://localhost:" + port + "/api/mysql/getCustomerInfo?customerId=" + customerId;

    ResponseEntity<String> responseEntity = restTemplate.getForEntity(
        url,
        String.class
    );
  }

  @RepeatedTest(1000)
  void getReservation() {

    Long customerId = 250001L;

    String url = "http://localhost:" + port + "/api/mysql/getReservation?customerId=" + customerId;

    ResponseEntity<String> responseEntity = restTemplate.getForEntity(
        url,
        String.class
    );
  }
}