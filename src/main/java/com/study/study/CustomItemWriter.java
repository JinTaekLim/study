package com.study.study;

import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

@Component
public class CustomItemWriter implements ItemWriter<Integer> {

  @Override
  public void write(Chunk<? extends Integer> chunk) throws InterruptedException {
    for (Integer item : chunk) {
      System.out.println("Writing item: " + item);
    }
    Thread.sleep(1000);
  }
}
