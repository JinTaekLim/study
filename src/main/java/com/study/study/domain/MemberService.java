package com.study.study.domain;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Service
public class MemberService {

  public HttpSession getSession() {
    ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
    return attributes.getRequest().getSession();
  }

  public void setAttribute(HttpSession session, String key, Object value) {
    session.setAttribute(key, value);
  }

  public Object getValue(HttpSession session, String key) {
    return session.getAttribute(key);
  }
}
