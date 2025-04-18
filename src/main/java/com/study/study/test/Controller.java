package com.study.study.test;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController
@RequiredArgsConstructor
public class Controller {

    private final KakaoPayClient kakaoPayClient;

    @Value("${SecretKey-Dev}")
    private String key;
    private String testCID = "TC0ONETIME";
    private String num = "1";


    @GetMapping("/req")
    public Request.Res req(){
        Request.Req req = Request.Req.builder()
            .cid(testCID)
            .partner_order_id(num)
            .partner_user_id(num)
            .item_name("테스트 상품")
            .quantity(1)
            .total_amount(10)
            .tax_free_amount(0)
            .approval_url("http://localhost:8080/api/succ")
            .cancel_url("http://localhost:8080/api/can")
            .fail_url("http://localhost:8080/api/fail")
            .build();
        return kakaoPayClient.readyPayment(key, req);
    }

    @GetMapping("/succ")
    public String a(@RequestParam("pg_token") String pgToken) {
        System.out.println("성공");
        System.out.println("받은 pg_token: " + pgToken);
        return pgToken;
    }

    @GetMapping("/approve")
    public Approve.Res approve(@RequestParam String tid, @RequestParam String pgToken) {
        Approve.Req req = Approve.Req.builder()
            .cid(testCID)
            .tid(tid)
            .partner_order_id(num)
            .partner_user_id(num)
            .pg_token(pgToken)
            .build();

        return kakaoPayClient.approvePayment(key, req);
    }


    @GetMapping("/can")
    public void b() {
        System.out.println("취소");
    }

    @GetMapping("/fail")
    public void c() {
        System.out.println("실패");
    }
}
