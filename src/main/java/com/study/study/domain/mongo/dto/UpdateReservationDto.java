package com.study.study.domain.mongo.dto;

import com.study.study.domain.mongo.entity.ReservationMongo.ReservationItem;
import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
public class UpdateReservationDto {

  @Builder
  @Data
  public static class Request {
    private Long customerId;
    private List<ReservationItem> reservationItems;
  }

}
