package com.study.study;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Dto {

  private Long instituteId;
  private Long reservationId;
  private Long customerId;
  private double usedTime;
  private int lateCount;
  private int absenceCount;
}
