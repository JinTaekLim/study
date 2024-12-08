//package com.study.study.domain.mongo.entity;
//
//import jakarta.validation.constraints.NotNull;
//import java.time.LocalDate;
//import java.util.List;
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import org.springframework.data.annotation.Id;
//import org.springframework.data.mongodb.core.mapping.Document;
//
//@Document(collection = "progress")
//@Getter
//@NoArgsConstructor
//public class ReservationMongo {
//
//  @Id
//  private Long customersId;
//
//  private List<ReservationItem> reservationItems;
//
//  @Getter
//  @Builder
//  @NoArgsConstructor
//  @AllArgsConstructor
//  public static class ReservationItem {
//
//    @NotNull
//    private LocalDate date;
//    @NotNull
//    private String content;
//  }
//
//  @Builder
//  public ReservationMongo(Long customersId, List<ReservationItem> reservationItems) {
//    this.customersId = customersId;
//    this.reservationItems = reservationItems;
//  }
//}
