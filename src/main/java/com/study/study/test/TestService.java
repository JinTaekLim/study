package com.study.study.test;

import java.util.concurrent.Future;
import org.springframework.stereotype.Service;

@Service
public class TestService {

  private final VirtualThreadManager virtualThreadManager = new VirtualThreadManager();

  public void test() {

    Future<Integer> a = virtualThreadManager.submitAsync(() -> {
      delay();
      return 1;
    });

    Future<Integer> b = virtualThreadManager.submitAsync(() -> {
      delay();
      return 2;
    });

    Future<Integer> c = virtualThreadManager.submitAsync(() -> {
      delay();
      return 3;
    });

    Future<Integer> d = virtualThreadManager.submitAsync(() -> {
      delay();
      return 4;
    });

    int A = virtualThreadManager.extractResult(a);
    int B = virtualThreadManager.extractResult(b);
    int C = virtualThreadManager.extractResult(c);
    int D = virtualThreadManager.extractResult(d);

//    System.out.println("성공");
  }

  private void delay() {
    try {
      Thread.sleep(1500);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
