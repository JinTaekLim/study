package com.study.study.domain.mysql.dto;

import java.time.LocalDate;
import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
public class MysqlSaveDto {

  @Builder
  @Data
  public static class Request {
    private String name;
    private String phone;
    private LocalDate startDate;
    private LocalDate endDate;
    private List<ReservationItem> reservationItems;
  }

}
