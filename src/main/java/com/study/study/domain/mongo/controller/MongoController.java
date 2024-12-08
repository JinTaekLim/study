package com.study.study.domain.mongo.controller;

import com.study.study.domain.mongo.dto.MongoSaveDto;
import com.study.study.domain.mongo.entity.Customer;
import com.study.study.domain.mongo.entity.ReservationMongo;
import com.study.study.domain.mongo.entity.ReservationMongo.ReservationItem;
import com.study.study.domain.mongo.repository.CustomerMongoRepository;
import com.study.study.domain.mongo.repository.ReservationRepository;
import com.study.study.domain.mysql.CustomerMysqlRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/mongo")
@RestController
@RequiredArgsConstructor
public class MongoController {

    private final CustomerMongoRepository customerMongoRepository;
    private final ReservationRepository reservationRepository;
    private final CustomerMysqlRepository customerMysqlRepository;

    // 회원가입
    @PostMapping("save")
    public void save(@RequestBody MongoSaveDto.Request request) {
        Customer customerMongo = Customer.builder()
            .name(request.getName())
            .phone(request.getPhone())
            .startDate(request.getStartDate())
            .endDate(request.getEndDate())
            .build();
        customerMongoRepository.save(customerMongo);

        List<ReservationItem> reservationItemList = request.getReservationItems().stream()
            .map(progressItem -> ReservationItem.builder()
                .date(progressItem.getDate())
                .content(progressItem.getContent())
                .build())
            .toList();

        ReservationMongo reservation = ReservationMongo.builder()
            .customersId(customerMongo.getId())
            .reservationItems(reservationItemList)
            .build();

        reservationRepository.save(reservation);
    }

//    // 진도표 첫 저장
//    @PostMapping("/saveReservation")
//    public void saveReservation(@RequestBody SaveReservationDto.Request request) {
//        List<ReservationItem> reservationItemList = request.getReservationItems().stream()
//            .map(progressItem -> ReservationItem.builder()
//                .date(progressItem.getDate())
//                .content(progressItem.getContent())
//                .build())
//            .toList();
//
//        ReservationMongo reservation = ReservationMongo.builder()
//            .customersId(1L)
//            .reservationItems(reservationItemList)
//            .build();
//        reservationRepository.save(reservation);
//    }


//    // 진도표 업데이트
//    @PostMapping("updateReservation")
//    public void updateReservation(@RequestBody UpdateReservationDto.Request request) {
//        List<ReservationItem> reservationItemList = request.getReservationItems().stream()
//            .map(progressItem -> ReservationItem.builder()
//                .date(progressItem.getDate())
//                .content(progressItem.getContent())
//                .build())
//            .toList();
//
//        ReservationMongo reservation = ReservationMongo.builder()
//            .customersId(request.getCustomerId())
//            .reservationItems(reservationItemList)
//            .build();
//        reservationRepository.save(reservation);
//    }

    // 회원정보 조회
    @GetMapping("/getCustomerInfo")
    public void getCustomerInfo(@RequestParam Long customerId) {
        Customer customer = customerMysqlRepository.findById(customerId).get();
        ReservationMongo reservation = reservationRepository.findById(customerId).get();
    }

    // 진도표 조회
    @GetMapping("/getReservation")
    public void getReservation(@RequestParam Long customerId) {
        ReservationMongo reservation = reservationRepository.findById(customerId).get();
    }

}
