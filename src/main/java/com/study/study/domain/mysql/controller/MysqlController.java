package com.study.study.domain.mysql.controller;

import com.study.study.domain.mysql.Customer;
import com.study.study.domain.mysql.CustomerMysqlRepository;
import com.study.study.domain.mysql.Reservation;
import com.study.study.domain.mysql.dto.MysqlSaveDto;
import com.study.study.domain.mysql.dto.MysqlSaveReservationDto;
import com.study.study.domain.mysql.dto.ReservationItem;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/mysql")
@RestController
@RequiredArgsConstructor
public class MysqlController {

    private final CustomerMysqlRepository customerMysqlRepository;

    // 회원가입
    @PostMapping("save")
    public void save(@RequestBody MysqlSaveDto.Request request) {
        List<Reservation> reservations = request.getReservationItems().stream()
            .map(reservation -> Reservation.builder()
                .date(reservation.getDate())
                .content(reservation.getContent())
                .build())
            .toList();


        Customer customer = Customer.builder()
            .name(request.getName())
            .phone(request.getPhone())
            .startDate(request.getStartDate())
            .endDate(request.getEndDate())
            .reservation(reservations)
            .build();
        customerMysqlRepository.save(customer);

    }

//    // 진도표 첫 저장
//    @PostMapping("/saveReservation")
//    public void saveReservation(@RequestBody MysqlSaveReservationDto.Request request) {
//
//        Customer customer = customerMysqlRepository.findById(request.getCustomerId()).get();
//        List<Reservation> reservationItemList = request.getReservationItems().stream()
//            .map(progressItem -> Reservation.builder()
//                .date(progressItem.getDate())
//                .content(progressItem.getContent())
//                .build())
//            .toList();
//        customer.update(reservationItemList);
//
//        customerMysqlRepository.save(customer);
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
//
    // 회원정보 조회
    @GetMapping("/getCustomerInfo")
    public void getCustomerInfo(@RequestParam Long customerId) {
        Customer customer = customerMysqlRepository.findById(customerId).get();
    }

    // 진도표 조회
    @GetMapping("/getReservation")
    public void getReservation(@RequestParam Long customerId) {
        List<Reservation> reservation = customerMysqlRepository.findById(customerId).get().getReservation();
    }

}
