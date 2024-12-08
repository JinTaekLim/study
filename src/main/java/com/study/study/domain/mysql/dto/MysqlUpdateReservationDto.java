package com.study.study.domain.mysql.dto;

import com.study.study.domain.mysql.Reservation;
import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
public class MysqlUpdateReservationDto {

  @Builder
  @Data
  public static class Request {
    private Long customerId;
    private List<ReservationItem> reservationItems;
  }

}
