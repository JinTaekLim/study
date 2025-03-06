package com.study.study;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestCode {

  @Autowired
  private CustomerRepository redisRepository;

  @Test
  void test() {
    Long instituteId = 124L;
    int count = 22;

    for (int i = 0; i < count; i++) {
      Dto dto = Dto.builder()
          .instituteId(instituteId)
          .customerId((long) i)
          .reservationId((long) i)
          .usedTime(i)
          .absenceCount(i)
          .lateCount(i)
          .build();

      redisRepository.add(dto);
    }

    List<Dto> dtos = redisRepository.findByInstituteId(instituteId);


    assertThat(dtos.size()).isEqualTo(20);
    IntStream.range(0, 20).forEach(i -> {
      int value = count - 1 - i;
      assertThat(dtos.get(i).getReservationId()).isEqualTo(value);
      assertThat(dtos.get(i).getUsedTime()).isEqualTo(value);
      assertThat(dtos.get(i).getAbsenceCount()).isEqualTo(value);
      assertThat(dtos.get(i).getLateCount()).isEqualTo(value);
    });

  }
}
