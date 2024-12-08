//package com.study.study.test;
//
//import com.study.study.domain.mongo.entity.ReservationMongo;
//import com.study.study.domain.mongo.repository.ReservationRepository;
//import com.study.study.domain.mysql.CustomerRepository;
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//import lombok.RequiredArgsConstructor;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RequestMapping("/api")
//@RestController
//@RequiredArgsConstructor
//public class Controller {
//    private final CustomerRepository customerRepository;
//    private final ReservationRepository reservationRepository;
//
//    @GetMapping("/test")
//    public String test(){
//        return "test";
//    }
//
////    @GetMapping("a")
////    public void a() {
////
////        LocalDate startDate = LocalDate.of(2020, 1, 1);
////        LocalDate endDate = LocalDate.of(2020, 12, 31);
////
////        for (int i=1; i<500001; i++) {
////
////            List<Reservation> reservationList = new ArrayList<>();
////
////            for (int j=1; j<21; j++) {
////                reservationList.add(Reservation.builder()
////                    .date(startDate)
////                    .content(String.valueOf(i))
////                    .build());
////            }
////
////            Customer customer = Customer.builder()
////                .reservation(reservationList)
////                .name("name" + i)
////                .phone("phone" + i)
////                .startDate(startDate)
////                .endDate(endDate)
////                .build();
////            customerRepository.save(customer);
////
////            if (i % 10000 == 0) {
////                startDate = startDate.plusYears(1);
////                endDate = endDate.plusYears(1);
////            }
////        }
////    }
//
//
//    @GetMapping("mongo")
//    public void saveMongo(int start, int end) {
//        LocalDate date = LocalDate.of(2020, 1, 1);
//
//        for (int i = start; i < end; i++) {
//            System.out.println("i = " + i);
//            List<ProgressItem> progressItems = new ArrayList<>();
//
//            for (int j=1; j< 21; j++ ) {
//                progressItems.add(ProgressItem.builder()
//                    .content(String.valueOf(j))
//                    .date(date)
//                    .build());
//
//            }
//
//            ReservationMongo reservationMongo = ReservationMongo.builder()
//                .customersId((long) i)
//                .progressList(progressItems)
//                .build();
//            reservationRepository.save(reservationMongo);
//            if (i % 10000 == 0) {
//                date = date.plusYears(1);
//            }
//
//        }
//
//
//
//    }
//
//    @GetMapping("getMongo")
//    public long getMongo() {
//        return reservationRepository.count();
//    }
//
//    @GetMapping("DeleteMongo")
//    public void deleteMongo() {
//        reservationRepository.deleteAll();
//    }
//}
