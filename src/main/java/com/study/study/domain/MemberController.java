package com.study.study.domain;

import com.study.study.global.response.ApiResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

@RestController
@RequestMapping("/api/member")
@RequiredArgsConstructor
public class MemberController {

  private final MemberService memberService;

  @GetMapping("test")
  public ApiResponse<?> test() {
    return ApiResponse.ok();
  }

  @PostMapping("login")
  public ApiResponse<?> login() {
    HttpSession session = memberService.getSession();
    memberService.setAttribute(session, "key", "valueaa");
    Object value = memberService.getValue(session, "key");
    return ApiResponse.ok(value);
  }


}
