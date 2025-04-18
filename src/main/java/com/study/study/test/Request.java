package com.study.study.test;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

public class Request {

  @Data
  @Builder
  public static class Req{
    // 가맹점 코드
    private String cid;

    // 주문 번호
    private String partner_order_id;

    // 가맹점 회원 ID
    private String partner_user_id;

    // 상품명
    private String item_name;

    // 상품 수량
    private Integer quantity;

    // 상품 총액
    private Integer total_amount;

    // 상품 비과세 금액
    private Integer tax_free_amount;

    // 결제 성공 redirect url
    private String approval_url;

    // 결제 취소 redirect url
    private String cancel_url;

    // 결제 실패 redirct url
    private String fail_url;
  }

  @Data
  @Builder
  public static class Res{
    private String tid;
    private String next_redirect_app_url;
    private String next_redirect_mobile_url;
    private String next_redirect_pc_url;
    private String android_app_scheme;
    private String ios_app_scheme;
    private String created_at;
  }
}
