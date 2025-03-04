package com.study.study;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class CustomItemProcessor implements ItemProcessor<Integer, Integer> {

  @Override
  public Integer process(Integer item) throws InterruptedException {
    System.out.println("Processing item: " + item);
    return item;
  }
}
