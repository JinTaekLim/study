package com.study.study;

import org.springframework.batch.item.ItemReader;
import org.springframework.stereotype.Component;

@Component
public class CustomItemReader implements ItemReader<Integer> {

  private int count = 1;
  private int index = count + 100;
  @Override
  public Integer read() throws Exception {
    if (count <= index) {
      if (count > 10 && count < 20) throw new Exception("오류 발생");
      return count++;
    } else {
      return null;
    }
  }
}
