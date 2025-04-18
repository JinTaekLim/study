package com.study.study.test;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(
    name = "kakaoPayClient",
    url = "https://open-api.kakaopay.com"
)
public interface KakaoPayClient {

  @PostMapping(value = "/online/v1/payment/ready", consumes = "application/json")
  Request.Res readyPayment(
      @RequestHeader("Authorization") String authorization,
      @RequestBody Request.Req request
  );

  @PostMapping("/online/v1/payment/approve")
  Approve.Res approvePayment(
      @RequestHeader("Authorization") String authorization,
      @RequestBody Approve.Req request
  );
}
