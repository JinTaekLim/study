package com.study.study.domain.mongo.dto;

import com.study.study.domain.mongo.entity.ReservationMongo.ReservationItem;
import java.time.LocalDate;
import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
public class SaveReservationDto {

  @Builder
  @Data
  public static class Request {
    private List<ReservationItem> reservationItems;
  }

}
